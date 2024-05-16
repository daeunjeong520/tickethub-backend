package com.tickethub.backend.user.controller;

import com.tickethub.backend.user.service.UserService;
import com.tickethub.backend.user.vo.RequestUser;
import com.tickethub.backend.user.vo.ResponseUser;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    // 회원가입
    @PostMapping("/api/users/signup")
    public ResponseEntity<ResponseUser> signup(@RequestBody RequestUser requestUser) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(
                        ResponseUser.fromDto(userService.createUser(
                                requestUser.getEmail(),
                                requestUser.getUsername(),
                                requestUser.getPwd()
                        ))
                );
    }

    // 회원 단건 조회
    @GetMapping("/api/users/{userId}")
    public ResponseEntity<ResponseUser> getUser(@PathVariable("userId") Long userId) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(
                        ResponseUser.fromDto(
                                userService.getUserByUserId(userId)
                        )
                );
    }
}