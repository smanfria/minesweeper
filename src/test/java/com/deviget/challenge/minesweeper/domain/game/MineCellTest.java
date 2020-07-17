package com.deviget.challenge.minesweeper.domain.game;

import com.deviget.challenge.minesweeper.domain.game.MineCell;
import com.deviget.challenge.minesweeper.domain.game.MineExplosionException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class MineCellTest {

    @Test
    void isMine() {
        final MineCell mineCell = new MineCell();
        Assertions.assertTrue(mineCell.isMine());
    }

    @Test
    void print() {
        final MineCell mineCell = new MineCell();
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
            final MineCell cell = new MineCell();
            cell.reveal();
        });
    }

    @Test
    void isFlagged() {
        final MineCell mineCell = new MineCell();
        Assertions.assertFalse(mineCell.isFlagged());
    }

    @Test
    void isReveled() {
        final MineCell mineCell = new MineCell();
        Assertions.assertFalse(mineCell.isReveled());
    }

    @Test
    void flag() {
        final MineCell mineCell = new MineCell();
        Assertions.assertFalse(mineCell.isFlagged());
        Assertions.assertFalse(mineCell.isReveled());

        mineCell.flag();

        Assertions.assertTrue(mineCell.isFlagged());
        Assertions.assertFalse(mineCell.isReveled());
    }
}