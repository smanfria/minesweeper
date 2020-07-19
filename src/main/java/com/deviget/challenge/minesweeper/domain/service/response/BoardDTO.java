package com.deviget.challenge.minesweeper.domain.service.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BoardDTO {
    private int rows;
    private int columns;
    private int mines;
    private List<CellDTO> modifiedCells;
}
