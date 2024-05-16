package com.tickethub.backend.book.service;

import com.tickethub.backend.book.dto.BookDto;

import java.util.List;

public interface BookService {

    BookDto createBook(Long seatId, Integer seatNum); // 예매
    List<BookDto> getBookList(); // 유저 - 예매 목록 전체 조회
    BookDto getBook(Long bookId); // 예매 상세 조회
}