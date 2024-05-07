package com.tickethub.backend.ticket.service;

import com.tickethub.backend.ticket.domain.Performance;
import com.tickethub.backend.ticket.domain.Seat;
import com.tickethub.backend.ticket.dto.PerformanceDto;
import com.tickethub.backend.ticket.dto.SeatDto;
import com.tickethub.backend.ticket.repository.PerformanceRepository;
import com.tickethub.backend.ticket.repository.SeatRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Slf4j
public class PerformanceService {

    private final PerformanceRepository performanceRepository;
    private final SeatRepository seatRepository;

    // 공연 전체 조회
    public List<PerformanceDto> getAllPerformances() {
        return performanceRepository.findAll()
                .stream()
                .map(PerformanceDto::from)
                .collect(Collectors.toList());
    }

    // 공연 단건 조회
    public PerformanceDto getPerformance(Long performanceId) {
        Performance performance = performanceRepository.findById(performanceId)
                .orElseThrow(() -> new IllegalArgumentException("Not Found Performance"));

        return PerformanceDto.from(performance);
    }
}