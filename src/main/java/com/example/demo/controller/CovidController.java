package com.example.demo.controller;

import com.example.demo.dto.IAggResult;
import com.example.demo.entity.Covid;
import com.example.demo.service.CovidService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static com.example.demo.configuration.constant.CovidFilterCriteria.*;

@RestController
@RequestMapping("")
public class CovidController {

    private final CovidService covidService;

    public CovidController(CovidService covidService) {
        this.covidService = covidService;
    }

    @GetMapping("/covid/{id}")
    public ResponseEntity<Covid> getStudentById(@PathVariable Long id) {

        Optional<Covid> optCovid = covidService.getCovidById(id);

        if (!optCovid.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(optCovid.get());
    }

    @GetMapping("/covid/top5")
    public ResponseEntity<List<Covid>> getTop5SortedBy(@RequestParam(name = "by") String by) {
        switch (by) {
            case ACTIVE:
            case DEATH:
                return ResponseEntity.ok().body(
                    covidService.getTop5SortedBy(by)
                );
            default:
                return ResponseEntity.status(400).build();
        }
    }

    @GetMapping("/covid/total")
    public ResponseEntity<Long> getTotalBy(@RequestParam(name = "by") String by) {
        switch (by) {
            case ACTIVE:
            case DEATH:
                return ResponseEntity.ok().body(
                    covidService.getTotalOf(by)
                );
            default:
                return ResponseEntity.status(400).build();
        }
    }

    @GetMapping("/scan/report/scanDashboard")
    public ResponseEntity<List<IAggResult>> getImpactFactor() {
        return ResponseEntity.ok().body(
            covidService.getImpactFactors()
        );
    }
}
