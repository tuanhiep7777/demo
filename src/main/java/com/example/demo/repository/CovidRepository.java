package com.example.demo.repository;

import com.example.demo.dto.IAggResult;
import com.example.demo.entity.Covid;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CovidRepository extends JpaRepository<Covid, Long> {

    @Query("SELECT CASE WHEN :column = 'active' THEN SUM(active) WHEN :column = 'death' THEN SUM(death) END FROM covid")
    Long getTotalOf(String column);

    // The clause 'AS continent' is required because when not using the alias, Hibernate will generate
    // a dummy alias for that column, so the result cannot map into IAggResult properly
    // Excluding case: divide by 0
    @Query(
        "SELECT " +
        "   continent AS continent, " +
        "   1.0 * NVL(SUM(death), 0) / DECODE( (NVL(SUM(active), 0) + NVL(SUM(death), 0) + NVL(SUM(recovered), 0)), 0, 1, (NVL(SUM(active), 0) + NVL(SUM(death), 0) + NVL(SUM(recovered), 0)) ) AS impactFactor " +
        "FROM covid " +
        "GROUP BY continent")
    List<IAggResult> getImpactFactors();
}
