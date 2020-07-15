package com.deviget.challenge.minesweeper.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MineCellTest {

    @Test
    void isMine() {
        final MineCell mineCell = new MineCell();
        Assertions.assertTrue(mineCell.isMine());
    }

    @Test
    void print() {
        final MineCell mineCell = new MineCell();
        Assertions.assertEquals("m", mineCell.print());
    }
}