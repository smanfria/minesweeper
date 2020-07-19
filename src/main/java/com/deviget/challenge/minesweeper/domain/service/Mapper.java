package com.deviget.challenge.minesweeper.domain.service;

import com.deviget.challenge.minesweeper.domain.service.response.BoardDTO;
import com.deviget.challenge.minesweeper.domain.service.response.CellDTO;
import com.deviget.challenge.minesweeper.domain.service.response.GameDTO;
import com.deviget.challenge.minesweeper.domain.game.Board;
import com.deviget.challenge.minesweeper.domain.game.Cell;
import com.deviget.challenge.minesweeper.domain.game.Game;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.List;

@org.mapstruct.Mapper
interface Mapper {
    Mapper INSTANCE = Mappers.getMapper(Mapper.class);

    @Mapping(source = "id", target = "gameId")
    @Mapping(target = "elapsedTime", expression = "java(game.elapsedTime())")
    @Mapping(source = "status", target = "status")
    @Mapping(source = "board", target = "board")
    GameDTO transform(Game game);

    @Mapping(source = "rows", target = "rows")
    @Mapping(source = "columns", target = "columns")
    @Mapping(source = "mines", target = "mines")
    @Mapping(target = "modifiedCells", expression = "java(transform(board.getModifiedCells()))")
    BoardDTO transform(Board board);

    @Mapping(source = "row", target = "row")
    @Mapping(source = "column", target = "column")
    @Mapping(target = "value", expression = "java(cell.print())")
    CellDTO transform(Cell cell);


    default List<CellDTO> transform(List<Cell> cells) {
        List<CellDTO> results = new ArrayList<>(cells.size());

        for (Cell cell : cells) {
            results.add(transform(cell));
        }
        return results;
    }
}
