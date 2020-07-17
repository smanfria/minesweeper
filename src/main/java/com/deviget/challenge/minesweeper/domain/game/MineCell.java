package com.deviget.challenge.minesweeper.domain.game;

public class MineCell extends Cell {

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
