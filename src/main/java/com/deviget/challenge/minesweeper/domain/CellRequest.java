package com.deviget.challenge.minesweeper.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CellRequest {
    private int row;
    private int column;
}
