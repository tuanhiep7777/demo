package com.example.demo.service.impl;

import com.example.demo.dto.IAggResult;
import com.example.demo.entity.Covid;
import com.example.demo.repository.CovidRepository;
import com.example.demo.service.CovidService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;



@Service
public class CovidServiceImpl implements CovidService {

    private final CovidRepository covidRepository;

    public CovidServiceImpl(CovidRepository covidRepository) {
        this.covidRepository = covidRepository;
    }

    @Override
    public Optional<Covid> getCovidById(Long id) {
        return covidRepository.findById(id);
    }

    @Override
    public List<Covid> getTop5SortedBy(String column) {
        Pageable page = PageRequest.of(0, 5, Sort.by(Sort.Direction.DESC, column));
        return covidRepository.findAll(page).getContent();
    }

    @Override
    public Long getTotalOf(String column) {
        return covidRepository.getTotalOf(column);
    }

    @Override
    public List<IAggResult> getImpactFactors() {
        return covidRepository.getImpactFactors();
    }
}
