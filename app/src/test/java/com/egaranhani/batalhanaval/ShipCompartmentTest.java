package com.egaranhani.batalhanaval;

import junit.framework.TestCase;

/**
 * Created by egaranhani on 26/05/2015.
 */
public class ShipCompartmentTest extends TestCase {
    public void testShooting(){
        ShipCompartment shipCompartment = new ShipCompartment();
        assertEquals(shipCompartment.status(), BoardSpace.STATUS.SHIP);
        assertEquals(shipCompartment.shoot().status(), BoardSpace.STATUS.HIT);
        assertEquals(shipCompartment.shoot().status(), BoardSpace.STATUS.HIT);
    }
}