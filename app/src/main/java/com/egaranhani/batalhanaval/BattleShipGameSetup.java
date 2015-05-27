package com.egaranhani.batalhanaval;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by egaranhani on 27/05/2015.
 */
public class BattleShipGameSetup {
//        "  ", "  ", "  ", "S3", "  ", "  ", "  ", "  ", "  ", "  "
//        "  ", "  ", "S5", "S3", "S6", "S6", "S6", "S4", "S4", "  "
//        "  ", "  ", "S5", "  ", "  ", "  ", "  ", "  ", "  ", "  "
//        "  ", "  ", "S5", "  ", "  ", "  ", "  ", "S2", "S2", "  "
//        "  ", "S9", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  "
//        "  ", "S9", "  ", "S0", "S0", "S0", "S0", "S0", "S0", "  "
//        "  ", "S9", "S7", "S7", "S7", "  ", "  ", "  ", "  ", "S1"
//        "  ", "S9", "  ", "S8", "S8", "S8", "S8", "  ", "  ", "S1"
//        "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  "
//        "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  "

    public Board defaultSetup(){
        return defaultBoard(createShips());
    }

    private List<BattleShip> createShips() {
        List<BattleShip> ships = new ArrayList<>();
        ships.add(new BattleShip(2));
        ships.add(new BattleShip(2));
        ships.add(new BattleShip(2));
        ships.add(new BattleShip(2));
        ships.add(new BattleShip(3));
        ships.add(new BattleShip(3));
        ships.add(new BattleShip(3));
        ships.add(new BattleShip(4));
        ships.add(new BattleShip(4));
        ships.add(new BattleShip(6));
        return ships;
    }

    private Board defaultBoard(List<BattleShip> ships) {
        Board board = new Board();
        for (int i = 0; i < ships.size(); i++) {
            BattleShip ship = ships.get(i);
            board.putShip(ship, getInitialDefaultLine(i), getInitialDefaultColumn(i), getInitialDefaultDirection(i));
        }
        return board;
    }

    private Board.DIRECTION getInitialDefaultDirection(int i) {
        if(positions[i][2]==0)
            return Board.DIRECTION.VERTICAL;
        return Board.DIRECTION.HORIZONTAL;
    }

    private int getInitialDefaultLine(int i) {
        return positions[i][0];
    }

    private int getInitialDefaultColumn(int i) {
        return positions[i][1];
    }

    private int positions[][] = {{6,9,0},{3,7,1},{0,3,0},{1,7,1},{1,2,0},{1,4,1},{6,2,1},{7,3,1},{4,1,0},{5,3,1}};
}
