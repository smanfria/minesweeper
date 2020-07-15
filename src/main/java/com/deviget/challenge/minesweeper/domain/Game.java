package com.deviget.challenge.minesweeper.domain;

import java.time.Duration;
import java.time.LocalDateTime;

public class Game {
    private final String username;
    private final Board board;
    private final LocalDateTime startTime;

    private Game(String username, int rows, int columns, int mines) {
        this.username = username;
        this.board = Board.create(rows, columns, mines);
        this.startTime = LocalDateTime.now();
    }

    public static Game create(String username, int rows, int columns, int mines) {
        Validator.validate(username);
        return new Game(username, rows, columns, mines);
    }

    public String getUsername() {
        return username;
    }

    public int getRows() {
        return board.getRows();
    }

    public int getColumns() {
        return board.getColumns();
    }

    public int getMines() {
        return board.getMines();
    }

    public boolean isOver() {
        return false;
    }

    public Duration elapsedTime() {
        return Duration.between(startTime, LocalDateTime.now());
    }

    public void reveal(int row, int column) {
        board.reveal(row, column);
    }

    public void flag(int row, int column) {
        board.flag(row, column);
    }
}
