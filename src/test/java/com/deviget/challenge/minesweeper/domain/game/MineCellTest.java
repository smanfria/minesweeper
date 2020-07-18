package com.deviget.challenge.minesweeper.domain.game;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class MineCellTest {

    @Test
    void isMine() {
        final MineCell mineCell = new MineCell(0, 0);
        Assertions.assertTrue(mineCell.isMine());
    }

    @Test
    void print() {
        final MineCell mineCell = new MineCell(0, 0);
        Assertions.assertEquals(" ", mineCell.print());
        try {
            mineCell.reveal();
        } catch (MineExplosionException ignore) {

        }
        Assertions.assertEquals("m", mineCell.print());
    }

    @Test
    void reveal() {
        assertThrows(MineExplosionException.class, () -> {
            final MineCell cell = new MineCell(0, 0);
            cell.reveal();
        });
    }

    @Test
    void isFlagged() {
        final MineCell mineCell = new MineCell(0, 0);
        Assertions.assertFalse(mineCell.isFlagged());
    }

    @Test
    void isReveled() {
        final MineCell mineCell = new MineCell(0, 0);
        Assertions.assertFalse(mineCell.isReveled());
    }

    @Test
    void flag() {
        final MineCell mineCell = new MineCell(0, 0);
        Assertions.assertFalse(mineCell.isFlagged());
        Assertions.assertFalse(mineCell.isReveled());

        mineCell.flag();

        Assertions.assertTrue(mineCell.isFlagged());
        Assertions.assertFalse(mineCell.isReveled());
    }
}