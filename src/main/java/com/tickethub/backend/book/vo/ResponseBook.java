package com.tickethub.backend.book.vo;

import com.tickethub.backend.book.dto.BookDto;
import com.tickethub.backend.performance.vo.ResponsePerformance;
import com.tickethub.backend.performance.vo.ResponseSeat;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResponseBook {

    private Long bookId;
    private Long userId;
    //private ResponsePerformance responsePerformance;
    private ResponseSeat responseSeat;

    public static ResponseBook fromDto(BookDto bookDto) {
        return ResponseBook.builder()
                .bookId(bookDto.getBookId())
                .userId(bookDto.getUserDto().getUserId())
                //.responsePerformance(ResponsePerformance.fromDto(bookDto.getSeatDto().getPerformanceDto()))
                .responseSeat(ResponseSeat.fromDto(bookDto.getSeatDto()))
                .build();
    }
}
