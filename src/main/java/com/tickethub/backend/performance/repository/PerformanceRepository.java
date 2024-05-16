package com.tickethub.backend.performance.repository;

import com.tickethub.backend.performance.persist.PerformanceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PerformanceRepository extends JpaRepository<PerformanceEntity, Long> {

}