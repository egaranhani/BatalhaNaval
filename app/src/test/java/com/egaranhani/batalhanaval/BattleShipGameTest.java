package com.egaranhani.batalhanaval;

import junit.framework.TestCase;

/**
 * Created by egaranhani on 27/05/2015.
 */
public class BattleShipGameTest extends TestCase {
    public void testInitializeGame(){
        BattleShipGame game = new BattleShipGame();
        validateBoard(game.myBoard().board(), initialBoard);
        validateBoard(game.opponentBoard().board(), blankBoard);
    }

    public void testAttemptHit(){
        BattleShipGame game = new BattleShipGame();
        ShootAttempt attempt = new ShootAttempt();
        attempt.line = myShipsPositions[0][0];
        attempt.column = myShipsPositions[0][1];
        attempt.result = null;
        attempt.gameOver = false;

        String expectedBoard[][] = new String[][]{
                {"BLANK", "BLANK", "BLANK", "SHIP",  "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK"},
                {"BLANK", "BLANK", "SHIP",  "SHIP",  "SHIP",  "SHIP",  "SHIP",  "SHIP",  "SHIP",  "BLANK"},
                {"BLANK", "BLANK", "SHIP",  "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK"},
                {"BLANK", "BLANK", "SHIP",  "BLANK", "BLANK", "BLANK", "BLANK", "SHIP",  "SHIP",  "BLANK"},
                {"BLANK", "SHIP",  "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK"},
                {"BLANK", "SHIP",  "BLANK", "SHIP",  "SHIP",  "SHIP",  "SHIP",  "SHIP",  "SHIP",  "BLANK"},
                {"BLANK", "SHIP",  "SHIP",  "SHIP",  "SHIP",  "BLANK", "BLANK", "BLANK", "BLANK", "HIT"  },
                {"BLANK", "SHIP",  "BLANK", "SHIP",  "SHIP",  "SHIP",  "SHIP",  "BLANK", "BLANK", "SHIP" },
                {"BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK"},
                {"BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK"}
        };

        game.attempt(attempt);
        assertTrue(attempt.hit());
        assertFalse(attempt.gameOver);
        assertEquals(attempt.line, 6);
        assertEquals(attempt.column, 9);
        validateBoard(game.myBoard().board(), expectedBoard);
        validateBoard(game.opponentBoard().board(), blankBoard);
    }

    public void testAttemptSplash(){
        BattleShipGame game = new BattleShipGame();
        ShootAttempt attempt = new ShootAttempt();
        attempt.line = 0;
        attempt.column = 1;
        attempt.result = null;
        attempt.gameOver = true;

        String expectedBoard[][] = new String[][]{
                {"BLANK", "SPLASH","BLANK", "SHIP",  "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK"},
                {"BLANK", "BLANK", "SHIP",  "SHIP",  "SHIP",  "SHIP",  "SHIP",  "SHIP",  "SHIP",  "BLANK"},
                {"BLANK", "BLANK", "SHIP",  "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK"},
                {"BLANK", "BLANK", "SHIP",  "BLANK", "BLANK", "BLANK", "BLANK", "SHIP",  "SHIP",  "BLANK"},
                {"BLANK", "SHIP",  "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK"},
                {"BLANK", "SHIP",  "BLANK", "SHIP",  "SHIP",  "SHIP",  "SHIP",  "SHIP",  "SHIP",  "BLANK"},
                {"BLANK", "SHIP",  "SHIP",  "SHIP",  "SHIP",  "BLANK", "BLANK", "BLANK", "BLANK", "SHIP" },
                {"BLANK", "SHIP",  "BLANK", "SHIP",  "SHIP",  "SHIP",  "SHIP",  "BLANK", "BLANK", "SHIP" },
                {"BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK"},
                {"BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK"}
        };

        game.attempt(attempt);
        assertFalse(attempt.hit());
        assertFalse(attempt.gameOver);
        assertEquals(attempt.line, 0);
        assertEquals(attempt.column, 1);
        validateBoard(game.myBoard().board(), expectedBoard);
        validateBoard(game.opponentBoard().board(), blankBoard);
    }

    public void testAttemptHitUntilAllShipsDestroyed(){
        BattleShipGame game = new BattleShipGame();
        for (int i = 0; i < myShipsPositions.length-1; i++) {
            for (int j = 0; j < myShipsPositions[i][3]; j++) {
                int line = myShipsPositions[i][0];
                int column = myShipsPositions[i][1];
                if (myShipsPositions[i][2] == 0)
                    assertHitNotEndingGame(attemptHitting(game, line + j, column), line + j, column);
                else
                    assertHitNotEndingGame(attemptHitting(game, line, column + j), line, column + j);
            }
        }

        int lastPos = myShipsPositions.length - 1;
        int line = myShipsPositions[lastPos][0];
        int column = myShipsPositions[lastPos][1];
        int dir = myShipsPositions[lastPos][2];
        int size = myShipsPositions[lastPos][3];
        for (int i = 0; i < myShipsPositions[lastPos][3]-1; i++) {
            if (dir == 0)
                assertHitNotEndingGame(attemptHitting(game, line + i, column), line + i, column);
            else
                assertHitNotEndingGame(attemptHitting(game, line, column + i), line, column + i);
        }
        ShootAttempt attempt = new ShootAttempt();
        if (dir == 0) {
            attempt.line = line + size - 1;
            attempt.column = column;
        } else{
            attempt.line = line;
            attempt.column = column + size - 1;
        }
        attempt.result = null;
        attempt.gameOver = false;

        String expectedBoard[][] = new String[][]{
                {"BLANK", "BLANK", "BLANK", "HIT",   "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK"},
                {"BLANK", "BLANK", "HIT",   "HIT",   "HIT",   "HIT",   "HIT",   "HIT",   "HIT",   "BLANK"},
                {"BLANK", "BLANK", "HIT",   "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK"},
                {"BLANK", "BLANK", "HIT",   "BLANK", "BLANK", "BLANK", "BLANK", "HIT",   "HIT",   "BLANK"},
                {"BLANK", "HIT",   "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK"},
                {"BLANK", "HIT",   "BLANK", "HIT",   "HIT",   "HIT",   "HIT",   "HIT",   "HIT",   "BLANK"},
                {"BLANK", "HIT",   "HIT",   "HIT",   "HIT",   "BLANK", "BLANK", "BLANK", "BLANK", "HIT"  },
                {"BLANK", "HIT",   "BLANK", "HIT",   "HIT",   "HIT",   "HIT",   "BLANK", "BLANK", "HIT"  },
                {"BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK"},
                {"BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK"}
        };

        game.attempt(attempt);
        validateBoard(game.myBoard().board(),expectedBoard);
        assertTrue(attempt.hit());
        assertTrue(attempt.gameOver);
        assertEquals(attempt.line, line);
        assertEquals(attempt.column, column + size - 1);
    }

    public void testResponseHit(){
        BattleShipGame game = new BattleShipGame();
        ShootAttempt attempt = new ShootAttempt();
        attempt.line = 5;
        attempt.column = 3;
        attempt.result = BoardSpace.STATUS.HIT;
        attempt.gameOver = false;

        assertFalse(game.response(attempt));
        validateBoard(game.myBoard().board(), initialBoard);

        String expectedBoard[][] = new String[][]{
                {"BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK"},
                {"BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK"},
                {"BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK"},
                {"BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK"},
                {"BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK"},
                {"BLANK", "BLANK", "BLANK", "HIT",   "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK"},
                {"BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK"},
                {"BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK"},
                {"BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK"},
                {"BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK"}
        };
        validateBoard(game.opponentBoard().board(), expectedBoard);
    }

    public void testResponseHitEndingGame(){
        BattleShipGame game = new BattleShipGame();
        ShootAttempt attempt = new ShootAttempt();
        attempt.line = 5;
        attempt.column = 3;
        attempt.result = BoardSpace.STATUS.HIT;
        attempt.gameOver = true;

        assertTrue(game.response(attempt));
        validateBoard(game.myBoard().board(), initialBoard);

        String expectedBoard[][] = new String[][]{
                {"BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK"},
                {"BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK"},
                {"BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK"},
                {"BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK"},
                {"BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK"},
                {"BLANK", "BLANK", "BLANK", "HIT",   "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK"},
                {"BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK"},
                {"BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK"},
                {"BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK"},
                {"BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK"}
        };
        validateBoard(game.opponentBoard().board(), expectedBoard);
    }

    public void testResponseSplash(){
        BattleShipGame game = new BattleShipGame();
        ShootAttempt attempt = new ShootAttempt();
        attempt.line = 5;
        attempt.column = 3;
        attempt.result = BoardSpace.STATUS.SPLASH;
        attempt.gameOver = true;

        assertFalse(game.response(attempt));
        validateBoard(game.myBoard().board(), initialBoard);

        String expectedBoard[][] = new String[][]{
                {"BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK"},
                {"BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK"},
                {"BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK"},
                {"BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK"},
                {"BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK"},
                {"BLANK", "BLANK", "BLANK", "SPLASH","BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK"},
                {"BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK"},
                {"BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK"},
                {"BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK"},
                {"BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK"}
        };
        validateBoard(game.opponentBoard().board(), expectedBoard);
    }

    private void validateBoard(BoardSpace[][] board, String[][] expectedBoard) {
        for (int i = 0; i < Board.BOARD_SIZE; i++) {
            for (int j = 0; j < Board.BOARD_SIZE; j++) {
                assertEquals(expectedBoard[i][j], board[i][j].status().name());
            }
        }
    }

    private ShootAttempt attemptHitting(BattleShipGame game, int line, int column){
        ShootAttempt attempt = new ShootAttempt();
        attempt.line = line;
        attempt.column = column;
        attempt.result = null;
        attempt.gameOver = false;
        game.attempt(attempt);
        return attempt;
    }

    private void assertHitNotEndingGame(ShootAttempt attempt, int line, int column){
        assertTrue(attempt.hit());
        assertFalse(attempt.gameOver);
        assertEquals(attempt.line, line);
        assertEquals(attempt.column, column);
    }

    private String initialBoard[][] = new String[][]{
            {"BLANK", "BLANK", "BLANK", "SHIP",  "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK"},
            {"BLANK", "BLANK", "SHIP",  "SHIP",  "SHIP",  "SHIP",  "SHIP",  "SHIP",  "SHIP",  "BLANK"},
            {"BLANK", "BLANK", "SHIP",  "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK"},
            {"BLANK", "BLANK", "SHIP",  "BLANK", "BLANK", "BLANK", "BLANK", "SHIP",  "SHIP",  "BLANK"},
            {"BLANK", "SHIP",  "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK"},
            {"BLANK", "SHIP",  "BLANK", "SHIP",  "SHIP",  "SHIP",  "SHIP",  "SHIP",  "SHIP",  "BLANK"},
            {"BLANK", "SHIP",  "SHIP",  "SHIP",  "SHIP",  "BLANK", "BLANK", "BLANK", "BLANK", "SHIP" },
            {"BLANK", "SHIP",  "BLANK", "SHIP",  "SHIP",  "SHIP",  "SHIP",  "BLANK", "BLANK", "SHIP" },
            {"BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK"},
            {"BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK"}
    };

    private String blankBoard[][] = new String[][]{
            {"BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK"},
            {"BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK"},
            {"BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK"},
            {"BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK"},
            {"BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK"},
            {"BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK"},
            {"BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK"},
            {"BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK"},
            {"BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK"},
            {"BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK"}
    };

    private int myShipsPositions[][] = {{6,9,0,2},{3,7,1,2},{0,3,0,2},{1,7,1,2},{1,2,0,3},{1,4,1,3},{6,2,1,3},{7,3,1,4},{4,1,0,4},{5,3,1,6}};
}