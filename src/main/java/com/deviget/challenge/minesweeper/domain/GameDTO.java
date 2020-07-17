package com.deviget.challenge.minesweeper.domain;

import lombok.Value;

@Value
public class GameDTO {
    String gameId;

    public GameDTO(String id, String username) {
        this.gameId = id;
    }
}
