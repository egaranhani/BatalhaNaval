package com.egaranhani.batalhanaval;

import junit.framework.TestCase;

/**
 * Created by egaranhani on 26/05/2015.
 */
public class PlayerTest extends TestCase {

    public static final String PLAYER_1 = "player 1";

    public void testCreatePlayer(){
        Player player1 = new Player(PLAYER_1);
        assertEquals(player1.name(), PLAYER_1);
    }

    public void testShipsInitialPositions(){
        Player player1 = new Player(PLAYER_1);
        Board board = player1.setupInitialTestBoard();
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

    private void validateBoard(BoardSpace[][] board, String[][] expectedBoard) {
        for (int i = 0; i < Board.BOARD_SIZE; i++) {
            for (int j = 0; j < Board.BOARD_SIZE; j++) {
                assertEquals(expectedBoard[i][j], board[i][j].status().name());
            }
        }
    }
}