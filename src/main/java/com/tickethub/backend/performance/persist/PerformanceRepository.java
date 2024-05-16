package com.tickethub.backend.performance.persist;

import com.tickethub.backend.performance.persist.PerformanceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PerformanceRepository extends JpaRepository<PerformanceEntity, Long> {

}