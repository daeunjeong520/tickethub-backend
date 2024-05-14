package com.tickethub.backend.ticket.web;

import com.tickethub.backend.ticket.dto.PerformanceDto;
import com.tickethub.backend.ticket.service.PerformanceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/performances")
@RequiredArgsConstructor
@Slf4j
public class PerformanceController {

    private final PerformanceService performanceService;

    @GetMapping
    public List<PerformanceDto> getAllPerformances() {
        return performanceService.getAllPerformances();
    }

    // 공연 단건 조회 정보
    @GetMapping("/{performanceId}")
    public PerformanceDto getPerformance(@PathVariable(name="performanceId") Long performanceId) {
        return performanceService.getPerformance(performanceId);
    }
}