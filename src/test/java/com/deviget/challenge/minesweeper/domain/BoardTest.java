package com.deviget.challenge.minesweeper.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class BoardTest {

    private static final int rows = 20;
    private static final int columns = 20;
    private static final int mines = 100;

    @Test
    void testNewCustomBoard() {
        Board board = Board.create(rows, columns, mines);

        Assertions.assertEquals(rows, board.getRows());
        Assertions.assertEquals(columns, board.getColumns());
        Assertions.assertEquals(mines, board.getMines());
    }

    @Test
    void testRevealCell() {
        Board board = Board.create(rows, columns, mines);
        board.reveal(5, 5);
    }

    @Test
    void testFlagCell() {
        Board board = Board.create(rows, columns, mines);
        board.flag(5, 5);
    }

    @Test
    void testInvalidRevealThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            Board board = Board.create(rows, columns, mines);
            board.reveal(-5, -5);
        });
    }

    @Test
    void testInvalidFlagThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            Board board = Board.create(rows, columns, mines);
            board.flag(-5, -5);
        });
    }

}