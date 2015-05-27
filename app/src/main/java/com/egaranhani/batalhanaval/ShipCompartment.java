package com.egaranhani.batalhanaval;

/**
 * Created by egaranhani on 26/05/2015.
 */
public class ShipCompartment implements BoardSpace {

    @Override
    public BoardSpace shoot() {
        if(!hit)
            hit = true;
        return this;
    }

    @Override
    public STATUS status() {
        if(hit)
            return STATUS.HIT;
        return STATUS.SHIP;
    }

    boolean hit = false;
}
