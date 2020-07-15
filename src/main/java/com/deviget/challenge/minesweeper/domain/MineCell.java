package com.deviget.challenge.minesweeper.domain;

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
    public String print() {
        return "m";
    }

    @Override
    protected void doReveal() throws MineExplosionException {
        throw new MineExplosionException();
    }
}
