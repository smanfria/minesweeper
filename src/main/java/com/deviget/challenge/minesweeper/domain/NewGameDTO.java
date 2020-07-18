package com.deviget.challenge.minesweeper.domain;

import lombok.Value;

@Value
public class NewGameDTO {
    String gameId;
    String username;

    public NewGameDTO(String gameId, String username) {
        this.gameId = gameId;
        this.username = username;
    }
}
