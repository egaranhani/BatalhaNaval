package com.egaranhani.batalhanaval;

import junit.framework.TestCase;

/**
 * Created by egaranhani on 26/05/2015.
 */
public class BlankSpaceTest extends TestCase {
    public void testShooting(){
        assertEquals(new BlankSpace().shoot().status(), BoardSpace.STATUS.SPLASH);
    }

    public void testStatus(){
        assertEquals(new BlankSpace().status(), BoardSpace.STATUS.BLANK);
    }
}