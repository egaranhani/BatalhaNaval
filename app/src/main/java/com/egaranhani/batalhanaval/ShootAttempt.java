package com.egaranhani.batalhanaval;

/**
 * Created by egaranhani on 27/05/2015.
 */
public class ShootAttempt {
    public int line;
    public int column;
    public BoardSpace.STATUS result;
    public boolean gameOver = false;
    public String opponentMessage;

    public boolean hit(){
        return (result != null && result == BoardSpace.STATUS.HIT);
    }
}
