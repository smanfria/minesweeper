package com.deviget.challenge.minesweeper.domain;

import com.deviget.challenge.minesweeper.domain.game.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Duration;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GameDTO {
    private String gameId;
    private String username;
    private Duration elapsedTime;
    private Status status;
    private BoardDTO board;
}
