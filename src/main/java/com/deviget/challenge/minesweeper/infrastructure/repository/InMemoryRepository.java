package com.deviget.challenge.minesweeper.infrastructure.repository;

import com.deviget.challenge.minesweeper.domain.repository.GameNotFoundException;
import com.deviget.challenge.minesweeper.domain.repository.GameRepository;
import com.deviget.challenge.minesweeper.domain.game.Game;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class InMemoryRepository implements GameRepository {
    private final Map<String, Game> repo = new HashMap<>();

    @Override
    public void save(Game game) {
        repo.put(game.getId(), game);
    }

    @Override
    public Game get(String gameId) {
        Game game = repo.get(gameId);
        if (game == null) {
            throw new GameNotFoundException();
        }
        return game;
    }
}
