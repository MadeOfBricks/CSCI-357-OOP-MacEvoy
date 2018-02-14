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
public class CustomGamepad extends CustomMouse{
    int gyroX, gyroY;
    
    float rumbleMagnitude;
    boolean rumbleStart;

    public CustomGamepad(int _slotCount,String consoleType){
        super(_slotCount);
    }
    
    public void tilt(int xTilt,int yTilt){
        gyroX += xTilt;
        gyroY += yTilt;
    }
    
    public void rumbleStart(float _rumbleMagnitude){
        rumbleMagnitude = _rumbleMagnitude;
    }
    
    public void rumble(){
        rumbleMagnitude -= .1;
    }
    
}
