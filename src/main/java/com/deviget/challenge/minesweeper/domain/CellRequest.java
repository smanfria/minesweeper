package com.deviget.challenge.minesweeper.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CellRequest {
    private int row;
    private int column;
}
