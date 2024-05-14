package com.tickethub.backend.init;

import com.tickethub.backend.ticket.domain.Performance;
import com.tickethub.backend.ticket.domain.Seat;
import com.tickethub.backend.ticket.repository.PerformanceRepository;
import com.tickethub.backend.ticket.repository.SeatRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@RequiredArgsConstructor
public class InitPerformance {

    private final PerformanceRepository performanceRepository;
    private final SeatRepository seatRepository;

    @PostConstruct
    public void initPerformance() {
        Performance performanceA = Performance.builder()
                .name("송가인인 2024 가인 디너 콘서트트")
                .viewingHours(2)
                .date(LocalDate.of(2024, 5, 1))
                .location("그랜드 하얏트 호텔")
                .cast("송가인")
                .posterPath("/img/imgD.png")
                .build();

        Seat seat_R = Seat.builder()
                .performance(performanceA)
                .seatType("R")
                .price(50000)
                .totalSeat(100)
                .build();

        Seat seat_S = Seat.builder()
                .performance(performanceA)
                .seatType("S")
                .price(80000)
                .totalSeat(200)
                .build();

        performanceRepository.save(performanceA);
        seatRepository.save(seat_R);
        seatRepository.save(seat_S);

        Performance performanceB = Performance.builder()
                .name("최우식 팬미팅")
                .viewingHours(3)
                .date(LocalDate.of(2024, 5, 10))
                .location("Yes24 Live Hall")
                .cast("최우식")
                .posterPath("/img/imgB.png")
                .build();

        Performance performanceC = Performance.builder()
                .name("O! NEW E!volution 3")
                .viewingHours(2)
                .date(LocalDate.of(2024, 5, 20))
                .location("Yes24 Live Hall")
                .cast("ONEWE")
                .posterPath("/img/imgA.png")
                .build();

        Performance performanceD = Performance.builder()
                .name("김창옥 토크쇼")
                .viewingHours(2)
                .date(LocalDate.of(2024, 5, 31))
                .location("안산 문화 예술의 전당")
                .cast("김창옥")
                .posterPath("/img/imgC.png")
                .build();

        performanceRepository.save(performanceB);
        performanceRepository.save(performanceC);
        performanceRepository.save(performanceD);
    }
}