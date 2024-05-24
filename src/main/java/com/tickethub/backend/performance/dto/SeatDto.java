package com.tickethub.backend.performance.dto;

import com.tickethub.backend.performance.persist.SeatEntity;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SeatDto {

    private Long seatId;
    private String seatType;
    private Integer totalSeat;
    private Integer price;
    private Integer seatLimit;

    // 공연 정보
    private String performanceName;  // 공연이름
    private Integer viewingHours;    // 관람시간
    private LocalDate date;          // 공연 날짜
    private String cast;             // 출연진
    private String location;         // 장소
    private String posterPath;       // 공연 이미지

    public static SeatDto from(SeatEntity seat) {
        return SeatDto.builder()
                .seatId(seat.getSeatId())
                .seatType(seat.getSeatType())
                .totalSeat(seat.getTotalSeat())
                .price(seat.getPrice())
                .seatLimit(seat.getSeatLimit())
                .performanceName(seat.getPerformanceEntity().getName())
                .viewingHours(seat.getPerformanceEntity().getViewingHours())
                .date(seat.getPerformanceEntity().getDate())
                .cast(seat.getPerformanceEntity().getCast())
                .location(seat.getPerformanceEntity().getLocation())
                .posterPath(seat.getPerformanceEntity().getPosterPath())
                .build();
    }
}