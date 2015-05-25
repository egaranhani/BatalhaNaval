package com.egaranhani.batalhanaval;

/**
 * Created by egaranhani on 24/05/2015.
 */

public class Board {

    public enum DIRECTION {
        HORIZONTAL,
        VERTICAL
    }

    public static final int BOARD_SIZE = 10;
    public static final String BLANK = "BLANK";
    public static final String SHIP = "SHIP";

    public Board() {
        initializeBoard();
    }

    public String get(int lin, int col) {
        return board[lin][col];
    }

    public boolean putShip(int size, int line, int column, DIRECTION direction){
        if(direction == DIRECTION.HORIZONTAL) {
            if(size+column > BOARD_SIZE)
                return false;
            for (int i = column; i < column+size; i++) {
                board[line][i] = SHIP;
            }
        } else {
            if(size+line > BOARD_SIZE)
                return false;
            for (int i = line; i < line+size; i++) {
                board[i][column] = SHIP;
            }
        }
        return true;
    }


    private void initializeBoard() {
        board = new String[BOARD_SIZE][BOARD_SIZE];
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                board[i][j] = BLANK;
            }
        }
    }

    private String [][] board;
}
