package com.egaranhani.batalhanaval;

import com.egaranhani.batalhanaval.Board.DIRECTION;
import com.egaranhani.batalhanaval.exceptions.OutOfBoundsException;

import junit.framework.TestCase;

public class BoardTest extends TestCase {

    private String[][] blankBoard = new String[][]{
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

    public void testCreateBoard() {
        Board b = new Board();
        validateBoard(b.board(), blankBoard);
    }

    public void testPutOneShipSize2HorizontalAtBeginOfBoard() {
        Board b = new Board();
        BattleShip battleShip = new BattleShip(2);
        assertTrue(b.putShip(battleShip, 0, 0, DIRECTION.HORIZONTAL));

        String expectedBoard[][] = new String[][]
            {   {"SHIP",  "SHIP",  "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK"},
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
        validateBoard(b.board(), expectedBoard);
    }

    public void testPutOneShipSize2HorizontalAtEndOfBoard() {
        Board b = new Board();
        int lineInsert = Board.BOARD_SIZE - 1;
        BattleShip battleShip = new BattleShip(2);
        assertTrue(b.putShip(battleShip, lineInsert, 8, DIRECTION.HORIZONTAL));

        String expectedBoard[][] = new String[][]
                {   {"BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK"},
                    {"BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK"},
                    {"BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK"},
                    {"BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK"},
                    {"BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK"},
                    {"BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK"},
                    {"BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK"},
                    {"BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK"},
                    {"BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK"},
                    {"BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "SHIP",  "SHIP" }
                };
        validateBoard(b.board(), expectedBoard);
    }

    public void testPutOneShipSize2VerticalAtBeginOfBoard() {
        Board b = new Board();
        BattleShip battleShip = new BattleShip(2);
        assertTrue(b.putShip(battleShip, 0, 0, DIRECTION.VERTICAL));

        String expectedBoard[][] = new String[][]
                {   {"SHIP",  "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK"},
                    {"SHIP",  "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK"},
                    {"BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK"},
                    {"BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK"},
                    {"BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK"},
                    {"BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK"},
                    {"BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK"},
                    {"BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK"},
                    {"BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK"},
                    {"BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK"}
                };
        validateBoard(b.board(), expectedBoard);
    }

    public void testPutOneShipSize2VerticalAtEndOfBoard() {
        Board b = new Board();
        int columnInsert = Board.BOARD_SIZE-1;
        BattleShip battleShip = new BattleShip(2);
        assertTrue(b.putShip(battleShip, 8, columnInsert, DIRECTION.VERTICAL));

        String expectedBoard[][] = new String[][]
                {   {"BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK"},
                    {"BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK"},
                    {"BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK"},
                    {"BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK"},
                    {"BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK"},
                    {"BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK"},
                    {"BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK"},
                    {"BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK"},
                    {"BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "SHIP" },
                    {"BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "SHIP" }
                };
        validateBoard(b.board(), expectedBoard);
    }

    public void testPutShipOverAnotherShipHorizontal(){
        Board b = new Board();
        BattleShip battleShip1 = new BattleShip(2);
        BattleShip battleShip2 = new BattleShip(2);
        assertTrue(b.putShip(battleShip1, 0, 0, DIRECTION.HORIZONTAL));
        assertFalse(b.putShip(battleShip2, 0, 0, DIRECTION.HORIZONTAL));

        String expectedBoard[][] = new String[][]
                {   {"SHIP",  "SHIP",  "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK"},
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
        validateBoard(b.board(), expectedBoard);
    }

    public void testPutShipOverTailOfAnotherShipHorizontal(){
        Board b = new Board();
        BattleShip battleShip1 = new BattleShip(2);
        BattleShip battleShip2 = new BattleShip(2);
        assertTrue(b.putShip(battleShip1, 0, 0, DIRECTION.HORIZONTAL));
        assertFalse(b.putShip(battleShip2, 0, 1, DIRECTION.HORIZONTAL));

        String expectedBoard[][] = new String[][]
                {   {"SHIP",  "SHIP",  "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK"},
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
        validateBoard(b.board(), expectedBoard);
    }

    public void testPutShipOverAnotherShipVertical(){
        Board b = new Board();
        BattleShip battleShip1 = new BattleShip(2);
        BattleShip battleShip2 = new BattleShip(2);
        assertTrue(b.putShip(battleShip1, 0, 0, DIRECTION.VERTICAL));
        assertFalse(b.putShip(battleShip2, 0, 0, DIRECTION.VERTICAL));

        String expectedBoard[][] = new String[][]
                {   {"SHIP",  "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK"},
                    {"SHIP",  "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK"},
                    {"BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK"},
                    {"BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK"},
                    {"BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK"},
                    {"BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK"},
                    {"BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK"},
                    {"BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK"},
                    {"BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK"},
                    {"BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK"}
                };
        validateBoard(b.board(), expectedBoard);
    }

    public void testPutShipOverTailOfAnotherShipVertical(){
        Board b = new Board();
        BattleShip battleShip1 = new BattleShip(2);
        BattleShip battleShip2 = new BattleShip(2);
        assertTrue(b.putShip(battleShip1, 0, 0, DIRECTION.VERTICAL));
        assertFalse(b.putShip(battleShip2, 1, 0, DIRECTION.VERTICAL));

        String expectedBoard[][] = new String[][]
                {   {"SHIP",  "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK"},
                    {"SHIP",  "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK"},
                    {"BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK"},
                    {"BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK"},
                    {"BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK"},
                    {"BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK"},
                    {"BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK"},
                    {"BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK"},
                    {"BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK"},
                    {"BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK"}
                };
        validateBoard(b.board(), expectedBoard);
    }

    public void testPutShipNextToAnotherShipHorizontal(){
        Board b = new Board();
        BattleShip battleShip1 = new BattleShip(2);
        BattleShip battleShip2 = new BattleShip(2);
        assertTrue(b.putShip(battleShip1, 0, 0, DIRECTION.HORIZONTAL));
        assertTrue(b.putShip(battleShip2, 0, 2, DIRECTION.HORIZONTAL));

        String expectedBoard[][] = new String[][]
                {   {"SHIP",  "SHIP",  "SHIP",  "SHIP",  "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK"},
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
        validateBoard(b.board(), expectedBoard);
    }

    public void testPutShipNextToAnotherShipVertical(){
        Board b = new Board();
        BattleShip battleShip1 = new BattleShip(2);
        BattleShip battleShip2 = new BattleShip(2);
        assertTrue(b.putShip(battleShip1, 0, 0, DIRECTION.VERTICAL));
        assertTrue(b.putShip(battleShip2, 2, 0, DIRECTION.VERTICAL));

        String expectedBoard[][] = new String[][]
                {   {"SHIP",  "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK"},
                    {"SHIP",  "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK"},
                    {"SHIP",  "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK"},
                    {"SHIP",  "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK"},
                    {"BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK"},
                    {"BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK"},
                    {"BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK"},
                    {"BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK"},
                    {"BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK"},
                    {"BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK"}
                };
        validateBoard(b.board(), expectedBoard);
    }

    public void testPutShipOutsideBoard(){
        Board b = new Board();
        validatePutShipOutOfBoundsException(b, -1, 0);
        validatePutShipOutOfBoundsException(b, 0, -1);
        validatePutShipOutOfBoundsException(b, 0, 10);
        validatePutShipOutOfBoundsException(b, 10, 0);
        validateBoard(b.board(), blankBoard);
    }

    public void testShootOutsideBoard(){
        Board b = new Board();
        validateShootOutOfBoundsException(b, 0, -1);
        validateShootOutOfBoundsException(b, -1, 0);
        validateShootOutOfBoundsException(b, 0, 10);
        validateShootOutOfBoundsException(b, 10, 0);
        validateBoard(b.board(), blankBoard);
    }

    public void testShootOnWater(){
        Board b = new Board();
        assertEquals(b.get(0,0).status(), BoardSpace.STATUS.BLANK);
        assertEquals(b.shoot(0,0).status(), BoardSpace.STATUS.SPLASH);

        String expectedBoard[][] = new String[][]
                {   {"SPLASH","BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK"},
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
        validateBoard(b.board(), expectedBoard);
    }

    public void testShootOnShip(){
        Board b = new Board();
        BattleShip battleShip = new BattleShip(2);
        b.putShip(battleShip, 0, 0, DIRECTION.HORIZONTAL);
        assertEquals(b.get(0,0).status(), BoardSpace.STATUS.SHIP);
        assertEquals(b.shoot(0,0).status(), BoardSpace.STATUS.HIT);

        String expectedBoard[][] = new String[][]
                {   {"HIT",   "SHIP",  "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK"},
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
        validateBoard(b.board(), expectedBoard);
    }

    public void testShootUntilAllShipsDestroyed(){
        Board b = new Board();
        BattleShip battleShip1 = new BattleShip(2);
        BattleShip battleShip2 = new BattleShip(2);
        assertTrue(b.putShip(battleShip1, 0, 0, DIRECTION.VERTICAL));
        assertTrue(b.putShip(battleShip2, 2, 0, DIRECTION.VERTICAL));

        assertEquals(b.shoot(0, 0).status(), BoardSpace.STATUS.HIT);
        assertFalse(battleShip1.isDestroyed());
        assertFalse(battleShip2.isDestroyed());
        assertFalse(b.allBattleshipsDestroyed());

        assertEquals(b.shoot(1, 0).status(), BoardSpace.STATUS.HIT);
        assertTrue(battleShip1.isDestroyed());
        assertFalse(battleShip2.isDestroyed());
        assertFalse(b.allBattleshipsDestroyed());

        assertEquals(b.shoot(2, 0).status(), BoardSpace.STATUS.HIT);
        assertTrue(battleShip1.isDestroyed());
        assertFalse(battleShip2.isDestroyed());
        assertFalse(b.allBattleshipsDestroyed());

        assertEquals(b.shoot(3, 0).status(), BoardSpace.STATUS.HIT);
        assertTrue(battleShip1.isDestroyed());
        assertTrue(battleShip2.isDestroyed());
        assertTrue(b.allBattleshipsDestroyed());

        String expectedBoard[][] = new String[][]
                {   {"HIT",   "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK"},
                    {"HIT",   "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK"},
                    {"HIT",   "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK"},
                    {"HIT",   "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK"},
                    {"BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK"},
                    {"BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK"},
                    {"BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK"},
                    {"BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK"},
                    {"BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK"},
                    {"BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK"}
                };
        validateBoard(b.board(), expectedBoard);
    }

    public void testMarkBoard(){
        Board b = new Board();
        validateBoard(b.board(),blankBoard);
        b.setHit(0, 3);
        String [][] expectedBoard = new String[][]{
                {"BLANK", "BLANK", "BLANK", "HIT",   "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK"},
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
        validateBoard(b.board(),expectedBoard);

        b.setSplash(0, 2);
        expectedBoard = new String[][]{
                {"BLANK", "BLANK", "SPLASH","HIT",   "BLANK", "BLANK", "BLANK", "BLANK", "BLANK", "BLANK"},
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
        validateBoard(b.board(),expectedBoard);
    }

    private void validateBoard(BoardSpace[][] board, String[][] expectedBoard) {
        for (int i = 0; i < Board.BOARD_SIZE; i++) {
            for (int j = 0; j < Board.BOARD_SIZE; j++) {
                assertEquals(expectedBoard[i][j], board[i][j].status().name());
            }
        }
    }

    private void validatePutShipOutOfBoundsException(Board b, int line, int column){
        try {
            BattleShip battleShip = new BattleShip(2);
            b.putShip(battleShip, line, column, DIRECTION.HORIZONTAL);
        } catch (OutOfBoundsException e){
            assertEquals(e.getMessage(), "Position on board [10][10] is out of bounds: [" + line + "][" + column + "]");
        }
    }

    private void validateShootOutOfBoundsException(Board b, int line, int column){
        try {
            b.shoot(line, column);
        } catch (OutOfBoundsException e){
            assertEquals(e.getMessage(), "Position on board [10][10] is out of bounds: [" + line + "][" + column + "]");
        }
    }

}