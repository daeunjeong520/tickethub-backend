package com.tickethub.backend.book.vo;

import com.tickethub.backend.book.dto.BookDto;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResponseBookInfo {

    private Long bookId;
    private String username;
    private String performanceName;  // 공연이름
    private String cast;             // 출연진
    private LocalDate date;          // 날짜
    private Integer bookSeatNum;     // 예약한 좌석 수
    private Integer bookPrice;       // 예약 가격
    private String seatType;         // 좌석 타입
    private String posterPath;       // 포스터 이미지

    public static ResponseBookInfo fromDto(BookDto bookDto) {
        return ResponseBookInfo.builder()
                .bookId(bookDto.getBookId())
                .username(bookDto.getUserDto().getUsername())
                .performanceName(bookDto.getSeatDto().getPerformanceName())
                .cast(bookDto.getSeatDto().getCast())
                .date(bookDto.getSeatDto().getDate())
                .bookSeatNum(bookDto.getBookSeatNum())
                .bookPrice(bookDto.getBookPrice())
                .posterPath(bookDto.getSeatDto().getPosterPath())
                .seatType(bookDto.getSeatDto().getSeatType())
                .build();
    }
}