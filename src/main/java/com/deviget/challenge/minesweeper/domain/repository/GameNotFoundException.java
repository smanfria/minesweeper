package com.deviget.challenge.minesweeper.domain.repository;

public class GameNotFoundException extends RuntimeException {
    public GameNotFoundException(String msg) {
        super(msg);
    }
}
