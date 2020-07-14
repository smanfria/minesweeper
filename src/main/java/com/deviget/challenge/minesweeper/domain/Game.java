package com.deviget.challenge.minesweeper.domain;

import java.time.Duration;
import java.time.LocalDateTime;

public class Game {
    private final String username;
    private final int rows;
    private final int columns;
    private final int mines;
    private final LocalDateTime startTime;

    private Game(String username, int rows, int columns, int mines) {
        this.username = username;
        this.rows = rows;
        this.columns = columns;
        this.mines = mines;
        this.startTime = LocalDateTime.now();
    }

    public static Game create(String username, int rows, int columns, int mines) {
        validate(username);
        validate(rows, "rows");
        validate(columns, "columns");
        validate(mines, "mines");
        return new Game(username, rows, columns, mines);
    }

    private static void validate(int intValue, String paramName) {
        if (intValue <= 0) {
            throw new IllegalArgumentException("Invalid value [" + intValue + "] for param [" + paramName + "].");
        }
    }

    private static void validate(String username) {
        if (username == null || "".equals(username.trim())) {
            throw new IllegalArgumentException("Invalid username.");
        }
    }

    public String getUsername() {
        return username;
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public int getMines() {
        return mines;
    }

    public boolean isEnded() {
        return false;
    }

    public Duration elapsedTime() {
        return Duration.between(startTime, LocalDateTime.now());
    }
}
