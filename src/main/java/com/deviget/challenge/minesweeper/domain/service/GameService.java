package com.deviget.challenge.minesweeper.domain.service;

import com.deviget.challenge.minesweeper.domain.game.Game;
import com.deviget.challenge.minesweeper.domain.repository.GameRepository;
import com.deviget.challenge.minesweeper.domain.service.request.CellRequest;
import com.deviget.challenge.minesweeper.domain.service.request.GameRequest;
import com.deviget.challenge.minesweeper.domain.service.response.GameDTO;
import com.deviget.challenge.minesweeper.domain.service.response.NewGameDTO;
import org.springframework.stereotype.Service;

@Service
public class GameService {

    private final GameRepository repository;

    public GameService(GameRepository repository) {
        this.repository = repository;
    }

    public NewGameDTO create(GameRequest request) {
        final Game game = Game.create(request.getUsername(), request.getRows(), request.getColumns(), request.getMines());
        repository.save(game);
        return new NewGameDTO(game.getId(), game.getUsername());
    }

    public GameDTO get(String gameId) {
        final Game game = repository.get(gameId);
        return toDto(game);
    }

    public GameDTO reveal(String gameId, CellRequest cellRequest) {
        final Game game = repository.get(gameId);
        game.reveal(cellRequest.getRow(), cellRequest.getColumn());
        return toDto(game);
    }

    public GameDTO flag(String gameId, CellRequest cellRequest) {
        final Game game = repository.get(gameId);
        game.flag(cellRequest.getRow(), cellRequest.getColumn());
        return toDto(game);
    }

    private GameDTO toDto(Game game) {
        return Mapper.INSTANCE.transform(game);
    }
}
