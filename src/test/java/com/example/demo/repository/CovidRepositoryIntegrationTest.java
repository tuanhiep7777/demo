package com.example.demo.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class CovidRepositoryIntegrationTest {

    @Autowired
    private CovidRepository covidRepository;

    @Test
    public void whenFindById_thenReturnProperEntity() {

    }
}
