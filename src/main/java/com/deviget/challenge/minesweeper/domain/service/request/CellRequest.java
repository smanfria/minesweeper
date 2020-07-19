package com.deviget.challenge.minesweeper.domain.service.request;

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
