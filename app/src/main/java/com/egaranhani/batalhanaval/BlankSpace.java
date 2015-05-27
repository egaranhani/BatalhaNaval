package com.egaranhani.batalhanaval;

/**
 * Created by egaranhani on 26/05/2015.
 */
public class BlankSpace implements BoardSpace {

    @Override
    public BoardSpace shoot() {
        return new SplashedSpace();
    }

    @Override
    public STATUS status() {
        return STATUS.BLANK;
    }
}
