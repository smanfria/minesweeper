package com.deviget.challenge.minesweeper.domain.service.response;

import lombok.Data;

@Data
public class CellDTO {
    private int row;
    private int column;
    private String value;
}
