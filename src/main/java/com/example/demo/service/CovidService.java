package com.example.demo.service;

import com.example.demo.dto.IAggResult;
import com.example.demo.entity.Covid;

import java.util.List;
import java.util.Optional;

public interface CovidService {

    Optional<Covid> getCovidById(Long id);

    List<Covid> getTop5SortedBy(String column);

    Long getTotalOf(String column);

    List<IAggResult> getImpactFactors();
}
