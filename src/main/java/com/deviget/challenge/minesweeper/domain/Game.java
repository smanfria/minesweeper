package com.deviget.challenge.minesweeper.domain;

import java.time.Duration;
import java.time.LocalDateTime;

public class Game {
    private final String username;
    private final Board board;
    private final LocalDateTime startTime;
    private LocalDateTime endTime;
    private Status status;


    private Game(String username, int rows, int columns, int mines) {
        this.username = username;
        this.board = Board.create(rows, columns, mines);
        this.startTime = LocalDateTime.now();
        this.status = Status.PLAYING;
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
        return status != Status.PLAYING;
    }

    public Duration elapsedTime() {
        LocalDateTime finalTime = endTime;
        if (finalTime == null) {
            finalTime = LocalDateTime.now();
        }
        return Duration.between(startTime, finalTime);
    }

    public void reveal(int row, int column) {
        try {
            board.reveal(row, column);
        } catch (MineExplosionException e) {
            this.lostGame();
            return;
        }
        this.checkGameStatus();
    }

    public void flag(int row, int column) {
        board.flag(row, column);
    }

    private void checkGameStatus() {
        if (board.isCompleted()) {
            this.wonGame();
        }
    }

    private void wonGame() {
        this.status = Status.WON;
        this.endTime = LocalDateTime.now();
    }

    private void lostGame() {
        this.status = Status.LOST;
        this.endTime = LocalDateTime.now();
    }
}
