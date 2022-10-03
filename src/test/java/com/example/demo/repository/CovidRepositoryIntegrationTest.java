package com.example.demo.repository;

import com.example.demo.entity.Covid;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

import static org.assertj.core.api.Assertions.*;

@DataJpaTest
class CovidRepositoryIntegrationTest {

    @Autowired
    private CovidRepository covidRepository;

    @Test
    public void whenFindById_thenReturnProperEntity() {

        // given
        Covid covid = new Covid(1L, "Indonesia", null, null, null, null);
        covidRepository.save(covid);

        // when
        Covid fromDb = covidRepository.findById(1L).get();

        // then
        assertThat(fromDb).isNotNull();
        assertThat(fromDb.getCountry()).isEqualTo(covid.getCountry());
    }
}
