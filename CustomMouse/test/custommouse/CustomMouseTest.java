/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package custommouse;

import custommouse.CustomMouse.powerState;
import custommouse.CustomMouse.moduleState;
import custommouse.CustomMouse.moduleType;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author droib
 */
public class CustomMouseTest {
    
    @Test
    public void CustomMouseTest() {
        CustomMouse inst = new CustomMouse(5);
        assertEquals(inst.slotCount,5);
        for (int i =0;i < 5;i++){
            assertEquals(inst.modules[i],moduleType.EMPTY);
        }
        for (int i =0;i < 5;i++){
            assertEquals(inst.moduleStates[i],moduleState.RELEASED);
        }
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of main method, of class CustomMouse.
     */
    @Test
    public void testSetPower(){
        CustomMouse inst = new CustomMouse(5);
        assertEquals(powerState.POWER_ON,inst.powered);
        inst.setPower(powerState.POWER_OFF);
        assertEquals(powerState.POWER_OFF,inst.powered);
    }
    
    @Test
    public void testSetMove(){
        CustomMouse inst = new CustomMouse(5);
        inst.setMove(20,-10);
        assertEquals(inst.x,20);
        assertEquals(inst.y,-10);
    }
    
    @Test
    public void testModules(){
        CustomMouse inst = new CustomMouse(5);
        inst.addModule(4,moduleType.BUTTON);
        assertEquals(inst.modules[4], moduleType.BUTTON);
        inst.removeModule(4);
        assertEquals(inst.modules[4], moduleType.EMPTY);
        
    }
    
    public void testModuleState(int slot){
        CustomMouse inst = new CustomMouse(2);
        inst.addModule(0,moduleType.BUTTON);
        inst.setModuleState(0,moduleState.PRESSED);
        assertEquals(inst.moduleStates[0],moduleState.PRESSED);
    }
    
    
    
    
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        CustomMouse.main(args);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
