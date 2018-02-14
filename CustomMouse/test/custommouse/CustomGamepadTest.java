/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package custommouse;

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
public class CustomGamepadTest {
    
    public CustomGamepadTest() {
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
     * Test of tilt method, of class CustomGamepad.
     */
    @Test
    public void testTilt() {
        System.out.println("tilt");
        int xTilt = 5;
        int yTilt = -5;
        CustomGamepad instance = new CustomGamepad(3,"XBox360");
        instance.tilt(xTilt, yTilt);
        assertEquals(xTilt,instance.gyroX);
        assertEquals(yTilt,instance.gyroY);
    }

    /**
     * Test of rumbleStart method, of class CustomGamepad.
     */
    @Test
    public void testRumbleStart() {
        System.out.println("rumbleStart");
        float _rumbleMagnitude = 5;
        CustomGamepad instance = new CustomGamepad(3,"XBox360");
        instance.rumbleStart(_rumbleMagnitude);
        assertEquals(_rumbleMagnitude,0, instance.rumbleMagnitude);
    }

    /**
     * Test of rumble method, of class CustomGamepad.
     */
    @Test
    public void testRumble() {
        System.out.println("rumble");
        CustomGamepad instance = new CustomGamepad(3,"XBox360");
        instance.rumbleStart(5);
        instance.rumble();
        assertEquals(4.9,0,instance.rumbleMagnitude);
    }
    
}
