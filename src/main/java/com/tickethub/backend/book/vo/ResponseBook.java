package com.tickethub.backend.book.vo;

import com.tickethub.backend.book.dto.BookDto;
import com.tickethub.backend.performance.dto.SeatDto;
import com.tickethub.backend.user.dto.UserDto;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResponseBook {

    // 좌석 정보
    private Long seatId;
    private String seatType;

    // 공연 정보
    private String performanceName;  // 공연이름
    private Integer viewingHours;    // 관람시간
    private LocalDate date;          // 공연 날짜
    private String cast;             // 출연진
    private String location;         // 장소
    private String posterPath;       // 공연 이미지

    // 예약 정보
    private String username;        // 예약자 이름
    private Long bookId;            // 예약 아이디
    private Integer bookSeatNum;    // 개수
    private Integer bookPrice;      // 전체 결제 가격

    public static ResponseBook fromDto(BookDto bookDto) {
        UserDto userDto = bookDto.getUserDto();
        SeatDto seatDto = bookDto.getSeatDto();

        return ResponseBook.builder()
                .seatId(seatDto.getSeatId())
                .seatType(seatDto.getSeatType())
                .performanceName(seatDto.getPerformanceName())
                .viewingHours(seatDto.getViewingHours())
                .date(seatDto.getDate())
                .cast(seatDto.getCast())
                .location(seatDto.getLocation())
                .posterPath(seatDto.getPosterPath())
                .username(userDto.getUsername())
                .bookId(bookDto.getBookId())
                .bookSeatNum(bookDto.getBookSeatNum())
                .bookPrice(bookDto.getBookPrice())
                .build();
    }
}