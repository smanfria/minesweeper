package com.deviget.challenge.minesweeper.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GameRequest {
    private String username;
    private int rows;
    private int columns;
    private int mines;
}
