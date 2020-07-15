package com.deviget.challenge.minesweeper.domain;

public class Validator {

    static void validate(String username) {
        if (username == null || "".equals(username.trim())) {
            throw new IllegalArgumentException("Invalid username.");
        }
    }

    static void validateGraterThanZero(int intValue, String paramName) {
        if (intValue <= 0) {
            throw new IllegalArgumentException("Invalid value [" + intValue + "] for param [" + paramName + "].");
        }
    }

    static void validate(int value, int values) {
        if (value <= 0 || value > values) {
            throw new IllegalArgumentException("Invalid cell value [" + value + "].");
        }
    }
}
