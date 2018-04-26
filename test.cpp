#include "pch.h"
#include "CustomMouse.cpp"

TEST(TestCaseName, TestName) {
  EXPECT_EQ(1, 1);
  EXPECT_TRUE(true);
}


TEST(testCustomMouseConstruct, TestName) {
	customMouse myMouse = customMouse(4);
	EXPECT_EQ(myMouse.slotCount, 4);
	for (int i = 0; i<myMouse.slotCount; i++) {
		EXPECT_EQ(myMouse.modules[i],myMouse.empty);
	}

}
/*
void setPower(powerState pow) {
	powered = pow;
};
*/

/*
powerState getPower() {
return powered;
}
*/

TEST(testCustomMousePower, TestName) {
	customMouse myMouse = customMouse(4);
	EXPECT_EQ(myMouse.getPower(), myMouse.power_on);
	myMouse.setPower(myMouse.power_off);
	EXPECT_EQ(myMouse.getPower(), myMouse.power_off);
}


/*
void setMove(int _x, int _y) {
	x += _x;
	y += _y;
};
*/
TEST(testCustomMouseMove, TestName) {
	customMouse myMouse = customMouse(4);
	EXPECT_EQ(myMouse.x, 0);
	EXPECT_EQ(myMouse.y, 0);
	myMouse.setMove(5, -4);
	EXPECT_EQ(myMouse.x, 5);
	EXPECT_EQ(myMouse.y, -4);
}


/*
void addModule(int slot, moduleType mod) {
	modules[slot] = mod;
};
*/

/*
void removeModule(int slot) {
	modules[slot] = empty;
};
*/

TEST(testCustomMouseModules, TestName) {
	customMouse myMouse = customMouse(4);
	EXPECT_EQ(myMouse.modules[0], myMouse.empty);
	myMouse.addModule(0, myMouse.button);
	EXPECT_EQ(myMouse.modules[0], myMouse.button);
	myMouse.setModuleState(0, myMouse.pressed);
	/*
	if (myMouse.moduleStates[0] == myMouse.pressed)
		assert(true);
	else
		assert(false);
	*/
	assert(myMouse.moduleStates[0] == myMouse.pressed);
	//EXPECT_EQ(myMouse.moduleStates[0], myMouse.pressed);
	myMouse.removeModule(0);
	EXPECT_EQ(myMouse.modules[0], myMouse.empty);
	assert(myMouse.moduleStates[0] == myMouse.released);

	/*
	if (myMouse.moduleStates[0] == myMouse.released)
		assert(true);
	else
		assert(false);
	*/
	//EXPECT_EQ(myMouse.moduleStates, myMouse.released);
}

/*
void setModuleState(int slot, moduleState state) {
	if (slot >= 0 && slot < slotCount) {
		if (modules[slot] != empty) {
			if (modules[slot] == button
				&& (state == pressed
					|| state == released)) {
				moduleStates[slot] = state;
			}
			else if (modules[slot] == wheel
				&& (state == wheel_up
					|| state == wheel_down)) {
				moduleStates[slot] = state;
			}
		}
	}
}
*/
