package com.deviget.challenge.minesweeper.domain.game;

public class NumCell extends Cell {
    private final int neighborsMines;

    public NumCell(int neighborsMines) {
        super();
        Validator.validatePositive(neighborsMines, "neighborsMines");
        this.neighborsMines = neighborsMines;
    }

    @Override
    public String toString() {
        return print();
    }

    @Override
    public boolean isMine() {
        return false;
    }

    @Override
    public String doPrint() {
        return String.valueOf(neighborsMines);
    }

    @Override
    protected void doReveal() {
        this.setReveled(true);
    }
}
