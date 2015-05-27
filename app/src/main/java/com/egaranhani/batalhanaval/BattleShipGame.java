package com.egaranhani.batalhanaval;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by egaranhani on 25/05/2015.
 */
public class BattleShipGame {
    public BattleShipGame(){
        BattleShipGameSetup setup = new BattleShipGameSetup();
        myBoard = setup.defaultSetup();
        oponentBoard = new Board();
    }
    Board myBoard;
    Board oponentBoard;

    public void response(ShootAttempt attempt) {
        if(attempt.result == null)
            return;

        oponentBoard.markAs(attempt.position[0], attempt.position[1], attempt.result);
    }
}
