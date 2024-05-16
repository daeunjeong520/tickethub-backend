package com.tickethub.backend.performance.repository;

import com.tickethub.backend.performance.persist.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SeatRepository extends JpaRepository<Seat, Long> {
    List<Seat> findByPerformance_PerformanceId(Long performanceId);
}