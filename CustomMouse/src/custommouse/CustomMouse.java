/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package custommouse;

/**
 *
 * @author droib
 */
public class CustomMouse {

    public enum moduleType{EMPTY, BUTTON, WHEEL}
    public enum moduleState{
        RELEASED, PRESSED, WHEEL_UP, WHEEL_DOWN
    }
    public enum powerState{POWER_OFF,POWER_ON}
    
    int slotCount;
    powerState powered;
    int x,y;
    moduleType modules[];
    moduleState moduleStates[];
    
    public CustomMouse(int _slotCount){
        slotCount = _slotCount;
        powered = powerState.POWER_ON;
        x =0;y=0;
        modules = new moduleType[_slotCount];
        for (int i = 0;i<slotCount;i++){
            modules[i] = moduleType.EMPTY;
        }
        moduleStates = new moduleState[_slotCount];
        for (int i = 0;i<slotCount;i++){
            moduleStates[i] = moduleState.RELEASED;
        }
    }
    
    public void setPower(powerState power){
        powered = power;
    }
    
    public void setMove(int xMove, int yMove){
        x += xMove;
        y += yMove;
    }
    
    public void addModule(int slot, moduleType mod){
        modules[slot] = mod;
    }
    
    public void removeModule(int slot){
        modules[slot] = moduleType.EMPTY;
    }
    
    public void setModuleState(int slot, moduleState state){
        if (slot >= 0 && slot < slotCount){
            if (modules[slot] != moduleType.EMPTY){
                if (modules[slot] == moduleType.BUTTON
                && (state == moduleState.PRESSED
                || state == moduleState.RELEASED)){
                    moduleStates[slot] = state;
                } else if (modules[slot] == moduleType.WHEEL
                && (state == moduleState.WHEEL_UP
                || state == moduleState.WHEEL_DOWN)){
                    moduleStates[slot] = state;
                }
            }
        }
    }
    
    
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
    
    
}
