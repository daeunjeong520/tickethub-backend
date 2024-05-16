package com.tickethub.backend.performance.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.tickethub.backend.performance.dto.SeatDto;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseSeat {

    private Long seatId;
    private String seatType;
    private Integer totalSeat;
    private Integer price;

    // dto -> response
    public static ResponseSeat fromDto(SeatDto seatDto) {
        return ResponseSeat.builder()
                .seatId(seatDto.getSeatId())
                .seatType(seatDto.getSeatType())
                .totalSeat(seatDto.getTotalSeat())
                .price(seatDto.getPrice())
                .build();
    }
}