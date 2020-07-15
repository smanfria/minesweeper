package com.deviget.challenge.minesweeper.domain;

public class MineCell implements Cell {
    @Override
    public boolean isMine() {
        return true;
    }

    @Override
    public String print() {
        return "m";
    }

    @Override
    public String toString() {
        return print();
    }
}
