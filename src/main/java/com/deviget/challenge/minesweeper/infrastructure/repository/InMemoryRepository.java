package com.deviget.challenge.minesweeper.infrastructure.repository;

import com.deviget.challenge.minesweeper.domain.game.Game;
import com.deviget.challenge.minesweeper.domain.repository.GameNotFoundException;
import com.deviget.challenge.minesweeper.domain.repository.GameRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
@Slf4j
public class InMemoryRepository implements GameRepository {
    private final Map<String, Game> repo = new HashMap<>();

    @Override
    public void save(Game game) {
        log.info("Saving game:" + game.getId() + " username:" + game.getUsername());
        repo.put(game.getId(), game);
    }

    @Override
    public Game get(String gameId) {
        log.info("Retrieving game:" + gameId);
        Game game = repo.get(gameId);
        if (game == null) {
            throw new GameNotFoundException("Game id:" + gameId + " not found.");
        }
        return game;
    }
}
