package com.tickethub.backend.performance.repository;

import com.tickethub.backend.performance.persist.Performance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PerformanceRepository extends JpaRepository<Performance, Long> {

}