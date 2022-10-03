package com.example.demo.service;

import com.example.demo.entity.Covid;
import com.example.demo.repository.CovidRepository;
import com.example.demo.service.impl.CovidServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CovidServiceImplTest {

    @InjectMocks
    private CovidServiceImpl covidService;

    @Mock
    private CovidRepository covidRepository;

    // Don't need to write unit test in this case cause of no extra logic provided in the service
    @Test
    void whenFindCovidByCertainId_thenReturnTheProperObject() {

        // given
        Covid obj = new Covid(1L, "Indonesia", null, null, null, null);
        when(covidRepository.findById(1L)).thenReturn( Optional.of(obj) );

        // when
        Covid found = covidService.getCovidById(1L).get();

        // then
        assertThat( found.getId() ).isEqualTo( obj.getId() );
        assertThat( found.getCountry() ).isEqualTo( obj.getCountry() );
    }
}
