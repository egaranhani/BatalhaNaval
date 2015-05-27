package com.egaranhani.batalhanaval;

import com.egaranhani.batalhanaval.exceptions.OutOfBoundsException;

/**
 * Created by egaranhani on 24/05/2015.
 */

public class Board {

    public enum DIRECTION {
        HORIZONTAL,
        VERTICAL
    }

    public static final int BOARD_SIZE = 10;

    public Board() {
        initializeBoard();
    }

    public BoardSpace get(int lin, int col) {
        return board[lin][col];
    }

    public boolean putShip(BattleShip battleShip, int line, int column, DIRECTION direction){
        validateBoardPosition(line,column);
        int shipSize = battleShip.size();
        if(direction.equals(DIRECTION.HORIZONTAL)) {
            if (!validateShipOnBoard(shipSize, column) || !validateShipNotOnOtherShip(line, column, shipSize, direction))
                return false;
            for (int i = column; i < column+shipSize; i++) {
                board[line][i] = battleShip.getCompartment(i-column);
            }
        } else {
            if (!validateShipOnBoard(shipSize, line)  || !validateShipNotOnOtherShip(line, column, shipSize, direction))
                return false;
            for (int i = line; i < line+shipSize; i++) {
                board[i][column] = battleShip.getCompartment(i-line);
            }
        }
        return true;
    }

    public BoardSpace shoot(int line, int column){
        validateBoardPosition(line, column);
        return board[line][column] = board[line][column].shoot();
    }

    private void validateBoardPosition(int line, int column) {
        if(line < 0 || line >= BOARD_SIZE || column < 0 || column >= BOARD_SIZE)
            throw new OutOfBoundsException(line, column);
    }

    public BoardSpace[][] board(){
        return board.clone();
    }

    private boolean validateShipOnBoard(int size, int position) {
        if(size+position > BOARD_SIZE)
            return false;
        return true;
    }

    private boolean validateShipNotOnOtherShip(int line, int column, int shipSize, DIRECTION dir){
        if(dir.equals(DIRECTION.HORIZONTAL)){
            for (int i = column; i < column+shipSize; i++) {
                if(board[line][i].status() != BoardSpace.STATUS.BLANK)
                    return false;
            }
        } else {
            for (int i = line; i < line+shipSize; i++) {
                if (board[i][column].status() != BoardSpace.STATUS.BLANK)
                    return false;
            }
        }
        return true;
    }

    private void initializeBoard() {
        board = new BoardSpace[BOARD_SIZE][BOARD_SIZE];
        BlankSpace blankSpace = new BlankSpace();
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                board[i][j] = blankSpace;
            }
        }
    }

    private BoardSpace [][] board;
}
