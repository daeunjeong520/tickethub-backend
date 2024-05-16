package com.tickethub.backend.book.service;

import com.tickethub.backend.book.dto.BookDto;
import com.tickethub.backend.book.persist.BookEntity;
import com.tickethub.backend.book.persist.BookRepository;
import com.tickethub.backend.performance.persist.SeatEntity;
import com.tickethub.backend.performance.persist.SeatRepository;
import com.tickethub.backend.user.persist.UserEntity;
import com.tickethub.backend.user.persist.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class BookServiceImpl implements BookService{

    private final UserRepository userRepository;
    private final SeatRepository seatRepository;
    private final BookRepository bookRepository;

    @Transactional
    @Override
    public BookDto createBook(Long seatId, Integer seatNum) {
        // 유저 조회
        UserEntity userEntity = validateUser();

        // 남은 좌석 조회
        SeatEntity seatEntity = seatRepository.findById(seatId)
                .orElseThrow(() -> new IllegalArgumentException("Seat Not Found"));

        if(seatEntity.getTotalSeat() == 0) {
            throw new IllegalStateException("There are no seats left");
        }

        // 좌석 예약 시 좌석 수 차감
        seatEntity.decreaseSeat(seatNum);

        // 예약 저장
        BookEntity bookEntity = BookEntity.builder()
                .userEntity(userEntity)
                .seatEntity(seatEntity)
                .build();

        bookRepository.save(bookEntity);
        return BookDto.from(bookEntity);
    }

    // 유저 - 예매 목록 조회
    @Override
    public List<BookDto> getBookList() {
        UserEntity userEntity = validateUser();
        return userEntity.getBooks()
                .stream()
                .map(BookDto::from)
                .collect(Collectors.toList());
    }

    // 유저 - 예매 상세 조회
    @Override
    public BookDto getBook(Long bookId) {
        validateUser();

        BookEntity bookEntity = bookRepository.findById(bookId)
                .orElseThrow(() -> new IllegalArgumentException("Book Not Found"));

        return BookDto.from(bookEntity);
    }

    // 유저 확인
    private UserEntity validateUser() {
        UserEntity userEntity = (UserEntity) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return userRepository.findByEmail(userEntity.getEmail())
                .orElseThrow(() -> new IllegalArgumentException("User Not Found"));
    }
}