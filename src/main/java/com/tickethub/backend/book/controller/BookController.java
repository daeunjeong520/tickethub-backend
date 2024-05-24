package com.tickethub.backend.book.controller;

import com.tickethub.backend.book.service.BookService;
import com.tickethub.backend.book.vo.RequestBook;
import com.tickethub.backend.book.vo.ResponseBook;
import com.tickethub.backend.book.vo.ResponseBookInfo;
import com.tickethub.backend.user.jwt.JWTUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/books")
@RequiredArgsConstructor
@Slf4j
public class BookController {

    private final BookService bookService;
    private final JWTUtil jwtUtil;

    // 예매
    @PostMapping
    public ResponseEntity<ResponseBookInfo> createBook(
            @CookieValue(value = "token") String token,
            @RequestBody RequestBook requestBook) {

        String username = jwtUtil.getUsername(token);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(
                        ResponseBookInfo.fromDto(
                                bookService.createBook(
                                        requestBook.getSeatId(),
                                        requestBook.getSeatNum(),
                                        username
                                )
                        )
                );
    }

    // 예매 목록 조회
    @GetMapping
    public ResponseEntity<List<ResponseBookInfo>> getBookList(
            @CookieValue(value = "token") String token
    ) {

        String username = jwtUtil.getUsername(token);
        return ResponseEntity.status(HttpStatus.OK)
                .body(
                        bookService.getBookList(username)
                                .stream()
                                .map(ResponseBookInfo::fromDto)
                                .collect(Collectors.toList())
                );
    }

    // 예매 단건 조회
    @GetMapping("/{bookId}")
    public ResponseEntity<ResponseBook> getBook(
            @PathVariable(name = "bookId") Long bookId,
            @CookieValue(value = "token") String token
    ) {
        String username = jwtUtil.getUsername(token);
        return ResponseEntity.status(HttpStatus.OK)
                .body(
                        ResponseBook.fromDto(
                                bookService.getBook(bookId, username)
                        )
                );
    }
}