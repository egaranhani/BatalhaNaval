package com.egaranhani.batalhanaval;

import android.app.backup.SharedPreferencesBackupHelper;

/**
 * Created by egaranhani on 25/05/2015.
 */
public class BattleShipGame {
    public BattleShipGame(){
        BattleShipGameSetup setup = new BattleShipGameSetup();
        myBoard = setup.defaultSetup();
        oponentBoard = new Board();
    }

    public void attempt(ShootAttempt attempt){
        attempt.result = myBoard.shoot(attempt.line, attempt.column).status();
        if(attempt.hit())
            attempt.gameOver = myBoard.allBattleshipsDestroyed();
        else
            attempt.gameOver = false;
    }

    public boolean response(ShootAttempt attempt) {
        if(attempt.result == BoardSpace.STATUS.HIT) {
            opponentBoard().setHit(attempt.line, attempt.column);
            return attempt.gameOver;
        }
        if(attempt.result == BoardSpace.STATUS.SPLASH) {
            opponentBoard().setSplash(attempt.line, attempt.column);
        }
        return false;
    }

    public Board myBoard(){
        return myBoard;
    }

    public Board opponentBoard(){
        return oponentBoard;
    }

    private Board myBoard;
    private Board oponentBoard;
}
