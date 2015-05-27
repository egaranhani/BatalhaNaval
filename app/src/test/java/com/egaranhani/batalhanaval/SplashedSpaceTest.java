package com.egaranhani.batalhanaval;

import junit.framework.TestCase;

/**
 * Created by egaranhani on 26/05/2015.
 */
public class SplashedSpaceTest extends TestCase {
    public void testShooting(){
        assertEquals(new SplashedSpace().shoot().status(), BoardSpace.STATUS.SPLASH);
    }

    public void testStatus(){
        assertEquals(new SplashedSpace().status(), BoardSpace.STATUS.SPLASH);
    }
}