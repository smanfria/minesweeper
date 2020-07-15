package com.deviget.challenge.minesweeper.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class NumCellTest {

    @Test
    void isMine() {
        final Cell cell = new NumCell(5);
        Assertions.assertFalse(cell.isMine());
    }

    @Test
    void print() {
        final Cell cell = new NumCell(5);
        Assertions.assertEquals("5", cell.print());
    }

    @Test
    void newInvalidNumCell() {
        assertThrows(IllegalArgumentException.class, () -> {
            new NumCell(-5);
        });
    }
}