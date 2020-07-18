package com.deviget.challenge.minesweeper.domain.game;

public class MineCell extends Cell {

    MineCell(int row, int column) {
        super(row, column);
    }

    @Override
    public String toString() {
        return print();
    }

    @Override
    public boolean isMine() {
        return true;
    }

    @Override
    public String doPrint() {
        return "m";
    }

    @Override
    protected void doReveal() throws MineExplosionException {
        this.setReveled(true);
        throw new MineExplosionException();
    }
}
