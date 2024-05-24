package com.tickethub.backend.performance.controller;

import com.tickethub.backend.performance.service.PerformanceService;
import com.tickethub.backend.performance.vo.ResponsePerformance;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/performances")
@RequiredArgsConstructor
@Slf4j
public class PerformanceController {

    private final PerformanceService performanceService;

    // 공연 전체 조회
    @GetMapping
    public ResponseEntity<List<ResponsePerformance>> getAllPerformances() {
        return ResponseEntity.status(HttpStatus.OK).body(
                performanceService.getAllPerformances()
                        .stream()
                        .map(ResponsePerformance::fromDto)
                        .collect(Collectors.toList()));
    }

    // 공연 단건 조회
    @GetMapping("/{performanceId}")
    public ResponseEntity<ResponsePerformance> getPerformance(
            @PathVariable("performanceId") Long performanceId
    ) {
        return ResponseEntity.status(HttpStatus.OK).body(
                ResponsePerformance.fromDto(
                        performanceService.getPerformance(performanceId)));
    }
}