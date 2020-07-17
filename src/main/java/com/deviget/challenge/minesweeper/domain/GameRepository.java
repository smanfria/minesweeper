package com.deviget.challenge.minesweeper.domain;

import com.deviget.challenge.minesweeper.domain.game.Game;

public interface GameRepository {
    void save(Game game);

    Game get(String gameId);
}
