package com.tickethub.backend.user.controller;

import com.tickethub.backend.user.dto.UserDto;
import com.tickethub.backend.user.security.TokenProvider;
import com.tickethub.backend.user.service.UserService;
import com.tickethub.backend.user.vo.RequestLogin;
import com.tickethub.backend.user.vo.RequestUser;
import com.tickethub.backend.user.vo.ResponseLogin;
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
    private final TokenProvider tokenProvider;

    // 회원가입
    @PostMapping("/api/users/signup")
    public ResponseEntity<ResponseUser> signup(@RequestBody RequestUser requestUser) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(
                        ResponseUser.fromDto(userService.createUser(
                                requestUser.getEmail(),
                                requestUser.getUsername(),
                                requestUser.getPassword(),
                                requestUser.getRoles()
                        ))
                );
    }

    // 로그인
    @PostMapping("/api/users/login")
    public ResponseEntity<ResponseLogin> login(@RequestBody RequestLogin requestLogin) {
        UserDto userDto = userService.loginUser(
                requestLogin.getEmail(),
                requestLogin.getPassword()
        );
        return ResponseEntity.status(HttpStatus.OK)
                .body(
                        ResponseLogin.builder()
                            .token(tokenProvider.generateToken(userDto.getUsername(), userDto.getRoles()))
                            .build()
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