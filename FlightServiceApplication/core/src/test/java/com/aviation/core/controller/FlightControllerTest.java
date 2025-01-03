package com.aviation.core.controller;

import com.aviation.core.entity.FlightEntity;
import com.aviation.core.service.FlightService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.lang.reflect.Array.get;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.mock.http.server.reactive.MockServerHttpRequest.post;
import static org.springframework.mock.http.server.reactive.MockServerHttpRequest.put;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@WebMvcTest(FlightController.class)
public class FlightControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private FlightService flightService;

    //Тест на удаление полета
    @Test
    public void testDeleteFlight() throws Exception {
        Long flightId = 1L;

        Mockito.doNothing().when(flightService).deleteFlight(flightId);

        mockMvc.perform(delete("/api/flights/delete/{id}", flightId))
                .andExpect(status().isNoContent());
    }



}

