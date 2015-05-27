package com.egaranhani.batalhanaval;

import junit.framework.TestCase;

/**
 * Created by egaranhani on 26/05/2015.
 */
public class SplashedWaterTest extends TestCase {
    public void testShooting(){
        assertEquals(new SplashedWater().shoot().status(), BoardSpace.STATUS.SPLASH);
    }

    public void testStatus(){
        assertEquals(new SplashedWater().status(), BoardSpace.STATUS.SPLASH);
    }
}