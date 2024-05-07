package com.tickethub.backend.ticket.dto;

import com.tickethub.backend.ticket.domain.Seat;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SeatDto {

    private Long seatId;
    private String seatType; // 좌석 타입 (R, S)
    private Integer totalSeat; // 좌석 총 개수
    private Integer price; // 좌석 가격

    public static SeatDto from(Seat seat) {
        return SeatDto.builder()
                .seatId(seat.getSeatId())
                .seatType(seat.getSeatType())
                .totalSeat(seat.getTotalSeat())
                .price(seat.getPrice())
                .build();
    }
}