package com.deviget.challenge.minesweeper.application;

import com.deviget.challenge.minesweeper.domain.*;
import com.deviget.challenge.minesweeper.domain.game.Status;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.google.gson.Gson;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.Duration;
import java.util.ArrayList;

import static org.hamcrest.core.Is.is;
import static org.mockito.ArgumentMatchers.any;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@ExtendWith(MockitoExtension.class)
class GameControllerTest {
    private static final String ENDPOINT = "/api/game/";

    private static final String ID = "id";


    private final MappingJackson2HttpMessageConverter jackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
    private MockMvc mvc;
    @InjectMocks
    private GameController controller;
    @Mock
    private GameService service;

    @BeforeEach
    public void setup() {
        jackson2HttpMessageConverter.getObjectMapper().setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
        mvc = MockMvcBuilders.standaloneSetup(controller)
                .setControllerAdvice(new GlobalControllerExceptionHandler())
                .setMessageConverters(jackson2HttpMessageConverter)
                .build();
    }

    @Test
    void newGame() throws Exception {
        final String username = "test";
        final String id = "gameId";

        Mockito.when(service.create(any(GameRequest.class))).thenReturn(new NewGameDTO(id, username));

        GameRequest gameRequest = new GameRequest(username, 10, 10, 10);

        final ResultActions resultActions = mvc.perform(post(ENDPOINT)
                .contentType(MediaType.APPLICATION_JSON)
                .content(toJson(gameRequest)));

        resultActions
                .andExpect(status().is(HttpStatus.CREATED.value()))
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.username", is(username)))
                .andExpect(jsonPath("$.game_id", is(id)));
    }

    @Test
    void getGame() throws Exception {
        final String username = "test";
        final String id = "gameId";

        Mockito.when(service.get(id)).thenReturn(new GameDTO(id, username, Duration.ZERO, Status.PLAYING,
                new BoardDTO(10, 10, 10, new ArrayList<>())));

        final ResultActions resultActions = mvc.perform(get(ENDPOINT + "/{id}", id));

        resultActions
                .andExpect(status().is(HttpStatus.OK.value()))
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.game_id", is(id)));
    }

    @Test
    void reveal() throws Exception {
        final String username = "test";
        final String id = "gameId";
        CellRequest cellRequest = new CellRequest(0, 0);


        Mockito.when(service.reveal(id, cellRequest)).thenReturn(new GameDTO(id, username, Duration.ZERO, Status.PLAYING,
                new BoardDTO(10, 10, 10, new ArrayList<>())));


        final ResultActions resultActions = mvc.perform(put(ENDPOINT + "/{id}/reveal", id)
                .contentType(MediaType.APPLICATION_JSON)
                .content(toJson(cellRequest)));
        resultActions
                .andExpect(status().is(HttpStatus.OK.value()))
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.game_id", is(id)));
    }

    @Test
    void flag() throws Exception {
        final String username = "test";
        final String id = "gameId";
        CellRequest cellRequest = new CellRequest(0, 0);

        Mockito.when(service.flag(id, cellRequest)).thenReturn(new GameDTO(id, username, Duration.ZERO, Status.PLAYING,
                new BoardDTO(10, 10, 10, new ArrayList<>())));

        final ResultActions resultActions = mvc.perform(put(ENDPOINT + "/{id}/flag", id)
                .contentType(MediaType.APPLICATION_JSON)
                .content(toJson(cellRequest)));
        resultActions
                .andExpect(status().is(HttpStatus.OK.value()))
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.game_id", is(id)));
    }

    private String toJson(Object aObject) {
        Gson gson = new Gson();
        return gson.toJson(aObject);
    }

}