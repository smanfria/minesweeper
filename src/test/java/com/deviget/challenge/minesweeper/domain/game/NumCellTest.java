package com.deviget.challenge.minesweeper.domain.game;

import com.deviget.challenge.minesweeper.domain.game.MineExplosionException;
import com.deviget.challenge.minesweeper.domain.game.NumCell;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class NumCellTest {

    @Test
    void isMine() {
        final NumCell cell = new NumCell(0,0,5);
        Assertions.assertFalse(cell.isMine());
    }

    @Test
    void print() throws MineExplosionException {
        final NumCell cell = new NumCell(0,0,5);
        Assertions.assertEquals(" ", cell.print());
        cell.reveal();
        Assertions.assertEquals("5", cell.print());
    }

    @Test
    void newInvalidNumCell() {
        assertThrows(IllegalArgumentException.class, () -> {
            new NumCell(0,0,-5);
        });
    }

    @Test
    void reveal() throws MineExplosionException {
        final NumCell cell = new NumCell(0,0,5);
        Assertions.assertFalse(cell.isFlagged());
        Assertions.assertFalse(cell.isReveled());

        cell.reveal();

        Assertions.assertTrue(cell.isReveled());
    }

    @Test
    void isFlagged() {
        final NumCell cell = new NumCell(0,0,5);
        Assertions.assertFalse(cell.isFlagged());
    }

    @Test
    void isReveled() {
        final NumCell cell = new NumCell(0,0,5);
        Assertions.assertFalse(cell.isReveled());
    }

    @Test
    void flag() {
        final NumCell cell = new NumCell(0,0,5);
        Assertions.assertFalse(cell.isFlagged());
        Assertions.assertFalse(cell.isReveled());

        cell.flag();

        Assertions.assertTrue(cell.isFlagged());
        Assertions.assertFalse(cell.isReveled());
    }
}