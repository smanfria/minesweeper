package com.deviget.challenge.minesweeper.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class GameTest {

    private static final String username = "testUserName";
    private static final int rows = 10;
    private static final int columns = 10;
    private static final int mines = 9;

    @Test
    void testNewCustomGame() {
        Game game = Game.create(username, rows, columns, mines);

        Assertions.assertEquals(username, game.getUsername());
        Assertions.assertEquals(rows, game.getRows());
        Assertions.assertEquals(columns, game.getColumns());
        Assertions.assertEquals(mines, game.getMines());

        Assertions.assertFalse(game.isEnded());
        Assertions.assertTrue(game.elapsedTime().toMillis() > 0);
    }

    @Test
    void testInvalidUsernameThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> Game.create("", rows, columns, mines));
    }

    @Test
    void testInvalidRowsThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> Game.create(username, 0, columns, mines));
    }

    @Test
    void testInvalidColumnsThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> Game.create(username, rows, 0, mines));
    }

    @Test
    void testInvalidMinesThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> Game.create(username, rows, columns, 0));
    }
}
