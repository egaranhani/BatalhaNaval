package com.egaranhani.batalhanaval;

import junit.framework.TestCase;

/**
 * Created by egaranhani on 26/05/2015.
 */
public class BattleShipTest extends TestCase {
    public void testCreation(){
        int shipSize = 3;
        BattleShip battleShip = new BattleShip(shipSize);
        assertEquals(battleShip.size(), shipSize);
        assertEquals(battleShip.isDestroyed(), false);
    }

    public void testOneHit(){
        int shipSize = 3;
        BattleShip battleShip = new BattleShip(shipSize);
        assertEquals(battleShip.getCompartment(0).shoot().status(), BoardSpace.STATUS.HIT);
        assertEquals(battleShip.isDestroyed(), false);
    }

    public void testTwoHits(){
        int shipSize = 3;
        BattleShip battleShip = new BattleShip(shipSize);
        assertEquals(battleShip.getCompartment(0).shoot().status(), BoardSpace.STATUS.HIT);
        assertEquals(battleShip.getCompartment(1).shoot().status(), BoardSpace.STATUS.HIT);
        assertEquals(battleShip.isDestroyed(), false);
    }

    public void testThreeHits(){
        int shipSize = 3;
        BattleShip battleShip = new BattleShip(shipSize);
        assertEquals(battleShip.getCompartment(0).shoot().status(), BoardSpace.STATUS.HIT);
        assertEquals(battleShip.getCompartment(1).shoot().status(), BoardSpace.STATUS.HIT);
        assertEquals(battleShip.getCompartment(2).shoot().status(), BoardSpace.STATUS.HIT);
        assertEquals(battleShip.isDestroyed(), true);
    }

    public void testThreeHitsOnSameCompartment(){
        int shipSize = 3;
        BattleShip battleShip = new BattleShip(shipSize);
        assertEquals(battleShip.getCompartment(0).shoot().status(), BoardSpace.STATUS.HIT);
        assertEquals(battleShip.getCompartment(1).shoot().status(), BoardSpace.STATUS.HIT);
        assertEquals(battleShip.getCompartment(1).shoot().status(), BoardSpace.STATUS.HIT);
        assertEquals(battleShip.isDestroyed(), false);
    }
}