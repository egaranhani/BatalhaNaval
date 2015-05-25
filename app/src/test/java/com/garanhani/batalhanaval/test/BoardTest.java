package com.garanhani.batalhanaval.test;

import com.egaranhani.batalhanaval.Board;
import com.egaranhani.batalhanaval.Board.DIRECTION;

import junit.framework.TestCase;

public class BoardTest extends TestCase {

    public void testCreateBoard() {
        Board b = new Board();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                assertEquals(b.get(i, j), Board.BLANK);
            }
        }
    }

    public void testPutOneShipSize2HorizontalAtBeginOfBoard() {
        Board b = new Board();
        assertTrue(b.putShip(2, 0, 0, DIRECTION.HORIZONTAL));
        assertEquals(b.get(0, 0), Board.SHIP);
        assertEquals(b.get(0, 1), Board.SHIP);
        for (int i = 2; i < Board.BOARD_SIZE; i++) {
            assertEquals(b.get(0, i), Board.BLANK);
        }
        for (int i = 1; i < Board.BOARD_SIZE; i++) {
            for (int j = 0; j < Board.BOARD_SIZE; j++) {
                assertEquals(b.get(i, j), Board.BLANK);
            }
        }
    }

    public void testPutOneShipSize2HorizontalAtEndOfBoard() {
        Board b = new Board();
        int lineInsert = Board.BOARD_SIZE - 1;
        assertTrue(b.putShip(2, lineInsert, 8, DIRECTION.HORIZONTAL));
        assertEquals(b.get(lineInsert, 8), Board.SHIP);
        assertEquals(b.get(lineInsert, 9), Board.SHIP);
        for (int i = 0; i < 8; i++) {
            assertEquals(b.get(lineInsert, i), Board.BLANK);
        }
        for (int i = 1; i < lineInsert; i++) {
            for (int j = 0; j < Board.BOARD_SIZE; j++) {
                assertEquals(b.get(i, j), Board.BLANK);
            }
        }
    }

    public void testPutOneShipSize2VerticalAtBeginOfBoard() {
        Board b = new Board();
        assertTrue(b.putShip(2, 0, 0, DIRECTION.VERTICAL));
        assertEquals(b.get(0, 0), Board.SHIP);
        assertEquals(b.get(1, 0), Board.SHIP);
        for (int i = 2; i < Board.BOARD_SIZE; i++) {
            assertEquals(b.get(i, 0), Board.BLANK);
        }
        for (int i = 0; i < Board.BOARD_SIZE; i++) {
            for (int j = 1; j < Board.BOARD_SIZE; j++) {
                assertEquals(b.get(i, j), Board.BLANK);
            }
        }
    }

    public void testPutOneShipSize2VerticalAtEndOfBoard() {
        Board b = new Board();
        int columnInsert = Board.BOARD_SIZE-1;
        assertTrue(b.putShip(2, 8, columnInsert, DIRECTION.VERTICAL));
        assertEquals(b.get(8, columnInsert), Board.SHIP);
        assertEquals(b.get(9, columnInsert), Board.SHIP);
        for (int i = 0; i < 8; i++) {
            assertEquals(b.get(i, columnInsert), Board.BLANK);
        }
        for (int i = 0; i < Board.BOARD_SIZE; i++) {
            for (int j = 0; j < columnInsert; j++) {
                assertEquals(b.get(i, j), Board.BLANK);
            }
        }
    }

}