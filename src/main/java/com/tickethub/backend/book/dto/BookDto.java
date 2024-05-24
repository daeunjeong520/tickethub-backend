package com.tickethub.backend.book.dto;

import com.tickethub.backend.book.persist.BookEntity;
import com.tickethub.backend.performance.dto.SeatDto;
import com.tickethub.backend.user.dto.UserDto;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookDto {

    private Long bookId;
    private UserDto userDto;
    private SeatDto seatDto;

    private Integer bookSeatNum;
    private Integer bookPrice;

    public static BookDto from(BookEntity bookEntity) {
        return BookDto.builder()
                .bookId(bookEntity.getBookId())
                .userDto(UserDto.from(bookEntity.getUserEntity()))
                .seatDto(SeatDto.from(bookEntity.getSeatEntity()))
                .bookSeatNum(bookEntity.getBookSeatNum())
                .bookPrice(bookEntity.getBookPrice())
                .build();
    }
}
