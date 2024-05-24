package com.tickethub.backend.book.service;

import com.tickethub.backend.book.dto.BookDto;
import com.tickethub.backend.book.persist.BookEntity;
import com.tickethub.backend.book.persist.BookRepository;
import com.tickethub.backend.performance.persist.SeatEntity;
import com.tickethub.backend.performance.persist.SeatRepository;
import com.tickethub.backend.user.persist.UserEntity;
import com.tickethub.backend.user.persist.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class BookServiceImpl implements BookService{

    private final UserRepository userRepository;
    private final SeatRepository seatRepository;
    private final BookRepository bookRepository;

    @Transactional
    @Override
    public BookDto createBook(Long seatId, Integer seatNum, String username) {
        // 유저 조회
        UserEntity userEntity = validateUser(username);

        // 남은 좌석 조회
        SeatEntity seatEntity = seatRepository.findById(seatId)
                .orElseThrow(() -> new IllegalArgumentException("Seat Not Found"));

        if(seatEntity.getTotalSeat() == 0) {
            throw new IllegalStateException("There are no seats left");
        }

        // 좌석 예약 시 좌석 수 차감
        seatEntity.decreaseSeat(seatNum);

        // 결제 금액
        Integer bookPrice = seatNum * seatEntity.getPrice();

        // 예약 저장
        return BookDto.from(
                bookRepository.save(
                        BookEntity.builder()
                                .userEntity(userEntity)
                                .seatEntity(seatEntity)
                                .bookSeatNum(seatNum)
                                .bookPrice(bookPrice)
                                .build()
                )
        );
    }

    // 유저 - 예매 목록 조회
    @Override
    public List<BookDto> getBookList(String username) {
        UserEntity userEntity = validateUser(username);

        return userEntity.getBooks()
                .stream()
                .map(BookDto::from)
                .collect(Collectors.toList());
    }

    // 유저 - 예매 상세 조회
    @Override
    public BookDto getBook(Long bookId, String username) {
        validateUser(username);

        BookEntity bookEntity = bookRepository.findById(bookId)
                .orElseThrow(() -> new IllegalArgumentException("Book Not Found"));

        return BookDto.from(bookEntity);
    }

    // 유저 확인
    private UserEntity validateUser(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new IllegalArgumentException("User Not Found"));
    }
}