package com.deviget.challenge.minesweeper.application;

import com.deviget.challenge.minesweeper.domain.service.GameService;
import com.deviget.challenge.minesweeper.domain.service.request.CellRequest;
import com.deviget.challenge.minesweeper.domain.service.request.GameRequest;
import com.deviget.challenge.minesweeper.domain.service.response.GameDTO;
import com.deviget.challenge.minesweeper.domain.service.response.NewGameDTO;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/game")
public class GameController {
    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Create a new game.")
    NewGameDTO newGame(@RequestBody GameRequest gameRequest) {
        return gameService.create(gameRequest);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get a game by id.")
    GameDTO getGame(@PathVariable("id") String gameId) {
        return gameService.get(gameId);
    }

    @PutMapping("/{id}/reveal")
    @Operation(summary = "Reveal a cell.")
    GameDTO reveal(@PathVariable("id") String gameId,
                   @RequestBody CellRequest cellRequest) {
        return gameService.reveal(gameId, cellRequest);
    }

    @PutMapping("/{id}/flag")
    @Operation(summary = "Flag a cell.")
    GameDTO flag(@PathVariable("id") String gameId,
                 @RequestBody CellRequest cellRequest) {
        return gameService.flag(gameId, cellRequest);
    }
}
