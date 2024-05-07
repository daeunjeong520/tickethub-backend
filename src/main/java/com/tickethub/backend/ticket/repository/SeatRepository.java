package com.tickethub.backend.ticket.repository;

import com.tickethub.backend.ticket.domain.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SeatRepository extends JpaRepository<Seat, Long> {
    List<Seat> findByPerformance_PerformanceId(Long performanceId);
}