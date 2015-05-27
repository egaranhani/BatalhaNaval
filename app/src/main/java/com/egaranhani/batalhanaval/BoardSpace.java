package com.egaranhani.batalhanaval;

/**
 * Created by egaranhani on 26/05/2015.
 */
public interface BoardSpace {
    public enum STATUS {
        BLANK,
        SHIP,
        HIT,
        SPLASH
    }
    public BoardSpace shoot();
    public STATUS status();
}
