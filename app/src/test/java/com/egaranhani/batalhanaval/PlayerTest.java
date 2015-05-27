package com.egaranhani.batalhanaval;

import junit.framework.TestCase;

import java.util.List;

/**
 * Created by egaranhani on 26/05/2015.
 */
public class PlayerTest extends TestCase {
    public void testCreatePlayer(){

    }

    public void testShipsInitialPositions(){
        Player player1 = new Player();
        Board board = player1.setupBoard();
        String expectedBoard[][] = new String[][]{
                {"BLANK", "BLANK", "BLANK",  "SHIP", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK"},
                {"BLANK", "BLANK",  "SHIP",  "SHIP",  "SHIP",  "SHIP",  "SHIP",  "SHIP",  "SHIP", "BLANK"},
                {"BLANK", "BLANK",  "SHIP", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK"},
                {"BLANK", "BLANK",  "SHIP", "BLANK", "BLANK", "BLANK", "BLANK",  "SHIP",  "SHIP", "BLANK"},
                {"BLANK",  "SHIP", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK"},
                {"BLANK",  "SHIP", "BLANK",  "SHIP",  "SHIP",  "SHIP",  "SHIP",  "SHIP",  "SHIP", "BLANK"},
                {"BLANK",  "SHIP",  "SHIP",  "SHIP",  "SHIP", "BLANK", "BLANK", "BLANK", "BLANK",  "SHIP"},
                {"BLANK",  "SHIP", "BLANK",  "SHIP",  "SHIP",  "SHIP",  "SHIP", "BLANK", "BLANK",  "SHIP"},
                {"BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK"},
                {"BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK"}
        };
        validateBoard(board.board(), expectedBoard);
    }

    private void validateBoard(Board.STATUS[][] board, String[][] expectedBoard) {
        for (int i = 0; i < Board.BOARD_SIZE; i++) {
            for (int j = 0; j < Board.BOARD_SIZE; j++) {
                assertEquals(expectedBoard[i][j], board[i][j].name());
            }
        }
    }
}