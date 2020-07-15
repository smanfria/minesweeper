package com.deviget.challenge.minesweeper.domain;

public class NumCell implements Cell {
    private final int neighborsMines;

    public NumCell(int neighborsMines) {
        this.neighborsMines = neighborsMines;
    }

    @Override
    public boolean isMine() {
        return false;
    }

    @Override
    public String print() {
        return String.valueOf(neighborsMines);
    }

    @Override
    public String toString() {
        return print();
    }
}
