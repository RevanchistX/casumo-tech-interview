package com.casumo.videorental.api.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@WebMvcTest(VideoControllerTest.class)
@AutoConfigureMockMvc(addFilters = false)
class VideoControllerTest {

    private static String API_URL = "http://localhost:8080/.rest/api/v1/videos";
    @Autowired
    MockMvc mockMvc;

    @Test
    public void testGetAll() throws Exception {
        mockMvc.perform(get(API_URL)).andDo(print());
    }

    @Test
    public void getById() throws Exception {
        mockMvc.perform(get(API_URL).contentType(MediaType.APPLICATION_JSON)).andDo(print());
    }
}