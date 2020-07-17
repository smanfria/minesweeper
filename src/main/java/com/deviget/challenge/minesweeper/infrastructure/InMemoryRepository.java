package com.deviget.challenge.minesweeper.infrastructure;

import com.deviget.challenge.minesweeper.domain.GameRepository;
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
        return repo.get(gameId);
    }
}
