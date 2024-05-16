package com.tickethub.backend.performance.persist;

import com.tickethub.backend.performance.persist.SeatEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SeatRepository extends JpaRepository<SeatEntity, Long> {
    List<SeatEntity> findByPerformance_PerformanceId(Long performanceId);
}