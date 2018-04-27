#include <iostream>
#include "pch.h"


using namespace std;

class customMouse{
	public:
	
	enum moduleType{empty, button, wheel};
	enum moduleState{released,pressed,wheel_up,wheel_down};
	enum powerState{power_off,power_on};
	
	int slotCount;
	powerState powered;
	int x,y;
	moduleType* modules;
	moduleState* moduleStates;
	
	customMouse(int _slots){
		slotCount = _slots;
		const int arSize = _slots;
		powered = power_on;
		x=0;y=0;
		modules = new moduleType[arSize];
		moduleStates = new moduleState[arSize];
		for(int i=0;i<slotCount;i++){
			modules[i] = empty;
		}
		for(int i=0;i<slotCount;i++){
			moduleStates[i] = released;
		}
	};
	
	void setPower(powerState pow){
		powered = pow;
	};
	
	powerState getPower(){
		return powered;
	}
	
	void setMove(int _x,int _y){
		x += _x;
		y += _y;
	};
	
	void addModule(int slot, moduleType mod){
		modules[slot] = mod;
	};
	
	void removeModule(int slot){
		modules[slot] = empty;
		moduleStates[slot] = released;
	};
	
	void setModuleState(int slot, moduleState state){
		if (slot >= 0 && slot < slotCount){
            if (modules[slot] != empty){
                if (modules[slot] == button
                && (state == pressed
                || state == released)){
                    moduleStates[slot] = state;
                } else if (modules[slot] == wheel
                && (state == wheel_up
                || state == wheel_down)){
                    moduleStates[slot] = state;
                }
            }
        }
	}
};
