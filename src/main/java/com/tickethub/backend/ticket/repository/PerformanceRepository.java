package com.tickethub.backend.ticket.repository;

import com.tickethub.backend.ticket.domain.Performance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PerformanceRepository extends JpaRepository<Performance, Long> {

}