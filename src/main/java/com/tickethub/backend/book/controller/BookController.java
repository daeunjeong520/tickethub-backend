package com.tickethub.backend.book.controller;

import com.tickethub.backend.book.service.BookService;
import com.tickethub.backend.book.vo.RequestBook;
import com.tickethub.backend.book.vo.ResponseBook;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    // 예매
    @PostMapping
    public ResponseEntity<ResponseBook> createBook(@RequestBody RequestBook requestBook) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(
                        ResponseBook.fromDto(
                                bookService.createBook(
                                        requestBook.getSeatId(),
                                        requestBook.getSeatNum()
                                )
                        )
                );
    }

    // 예매 목록 조회


    // 예매 단건 조회
}
