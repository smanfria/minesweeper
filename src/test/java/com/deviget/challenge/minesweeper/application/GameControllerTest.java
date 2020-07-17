package com.deviget.challenge.minesweeper.application;

import com.deviget.challenge.minesweeper.domain.GameRequest;
import com.deviget.challenge.minesweeper.domain.GameService;
import com.deviget.challenge.minesweeper.domain.NewGameDTO;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
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

import static org.hamcrest.core.Is.is;
import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@ExtendWith(MockitoExtension.class)
class GameControllerTest {
    private static final String ENDPOINT = "/api/game/";

    private static final String ROWS = "rows";
    private static final String COLUMNS = "columns";
    private static final String MINES = "mines";
    private static final String USERNAME = "username";

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

        //TODO
        String jsonBody = "";
        final ResultActions resultActions = mvc.perform(post(ENDPOINT)
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonBody));

        resultActions
                .andExpect(status().is(HttpStatus.CREATED.value()))
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.username", is(username)))
                .andExpect(jsonPath("$.id", is(id)));
    }

    @Test
    void getGame() {
        //TODO
    }

    @Test
    void reveal() {
        //TODO
    }

    @Test
    void flag() {
        //TODO
    }
}