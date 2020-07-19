package com.deviget.challenge.minesweeper.domain.service;

import com.deviget.challenge.minesweeper.domain.game.Game;
import com.deviget.challenge.minesweeper.domain.repository.GameRepository;
import com.deviget.challenge.minesweeper.domain.service.request.CellRequest;
import com.deviget.challenge.minesweeper.domain.service.request.GameRequest;
import com.deviget.challenge.minesweeper.domain.service.response.GameDTO;
import com.deviget.challenge.minesweeper.domain.service.response.NewGameDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class GameServiceTest {
    @Mock
    GameRepository repository;

    @InjectMocks
    GameService gameService;

    @Test
    void create() {
        GameRequest request = new GameRequest("test", 10, 10, 9);
        final NewGameDTO newGameDTO = gameService.create(request);
        Assertions.assertEquals(request.getUsername(), newGameDTO.getUsername());
        Assertions.assertNotNull(newGameDTO.getGameId());
        verify(repository, times(1)).save(any());
    }

    @Test
    void get() {
        final Game game = Game.create("test", 10, 10, 9);
        final String gameId = game.getId();
        Mockito.when(repository.get(gameId)).thenReturn(game);

        gameService.get(gameId);

        verify(repository, times(1)).get(gameId);
    }

    @Test
    void reveal() {
        final Game game = Game.create("test", 10, 10, 9);
        final String gameId = game.getId();
        Mockito.when(repository.get(gameId)).thenReturn(game);

        CellRequest request = new CellRequest(0, 0);
        gameService.reveal(gameId, request);

        verify(repository, times(1)).get(gameId);
    }

    @Test
    void flag() {

        final Game game = Game.create("test", 10, 10, 9);
        final String gameId = game.getId();
        Mockito.when(repository.get(gameId)).thenReturn(game);

        CellRequest request = new CellRequest(0, 0);
        final GameDTO gameDTO = gameService.flag(gameId, request);

        verify(repository, times(1)).get(gameId);
    }
}