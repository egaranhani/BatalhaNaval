package com.egaranhani.batalhanaval;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by egaranhani on 26/05/2015.
 */
public class Player {
    private Board board;
    private String name;
    private List<BattleShip> ships;
    private InitialState init = new InitialState();

    public Player(String playerName){
        name = new String(playerName);
    }

    public Board setupInitialTestBoard(){
        //TODO: o barcos serão passados pelo jogo
        board = new Board();
        ships = init.createBoats();
        return init.setDefaultBoard();
    }

    public boolean putShipOnBoard(BattleShip ship, int line, int column, Board.DIRECTION direction){
        return board.putShip(ship, line, column, direction);
    }

    public String name() {
        return name;
    }

    private class InitialState{
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

        private int positions[][] = {{6,9,0},{3,7,1},{0,3,0},{1,7,1},{1,2,0},{1,4,1},{6,2,1},{7,3,1},{4,1,0},{5,3,1}};

        private List<BattleShip> createBoats() {
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

        private Board setDefaultBoard() {
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

    }
}
