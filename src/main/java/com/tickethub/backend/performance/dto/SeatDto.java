package com.tickethub.backend.performance.dto;

import com.tickethub.backend.performance.persist.SeatEntity;
import lombok.*;

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

    //private PerformanceDto performanceDto; // 공연 정보

    public static SeatDto from(SeatEntity seat) {
        return SeatDto.builder()
                .seatId(seat.getSeatId())
                .seatType(seat.getSeatType())
                .totalSeat(seat.getTotalSeat())
                .price(seat.getPrice())
                .seatLimit(seat.getSeatLimit())
      //          .performanceDto(PerformanceDto.from(seat.getPerformanceEntity()))
                .build();
    }
}