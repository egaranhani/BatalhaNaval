package com.egaranhani.batalhanaval;

/**
 * Created by egaranhani on 26/05/2015.
 */
public class SplashedSpace implements BoardSpace {
    @Override
    public BoardSpace shoot() {
        return this;
    }

    @Override
    public STATUS status() {
        return STATUS.SPLASH;
    }
}
