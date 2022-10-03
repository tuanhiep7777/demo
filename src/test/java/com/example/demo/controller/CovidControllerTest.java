package com.example.demo.controller;

import com.example.demo.entity.Covid;
import com.example.demo.service.CovidService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@WebMvcTest(CovidController.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CovidControllerTest {

    private String uri = "";

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CovidService covidService;

    @BeforeAll
    public void setUp() {
        when(covidService.getCovidById(1L)).thenReturn( Optional.of( new Covid(1L, "Indonesia", null, null, null, null) ) );
    }

    @Test
    void givenNonExistedId_whenGetStudentById_thenReturn404() throws Exception {

        this.mockMvc.perform(get("/covid/0")).andExpect(status().isNotFound());
    }

    @Test
    void givenExistedId_whenGetStudentById_thenReturnStudentData() throws Exception {

        this.mockMvc.perform(get("/covid/1"))
            .andExpect(status().isOk())
            .andExpect(content()
                .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$.country").value("Indonesia"))
        ;
    }
}
