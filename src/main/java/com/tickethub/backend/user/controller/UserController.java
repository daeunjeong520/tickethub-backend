package com.tickethub.backend.user.controller;

import com.tickethub.backend.user.dto.UserDto;
import com.tickethub.backend.user.security.TokenProvider;
import com.tickethub.backend.user.service.UserService;
import com.tickethub.backend.user.vo.RequestLogin;
import com.tickethub.backend.user.vo.RequestUser;
import com.tickethub.backend.user.vo.ResponseUser;
import io.jsonwebtoken.Claims;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final TokenProvider tokenProvider;

    // 회원가입
    @PostMapping("/signup")
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
    @PostMapping("/login")
    public ResponseEntity login(@RequestBody RequestLogin requestLogin, HttpServletResponse res) {
        UserDto userDto = userService.loginUser(
                requestLogin.getEmail(),
                requestLogin.getPassword()
        );

        if(userDto != null) {
            String token = tokenProvider.generateToken(userDto.getUserId(), userDto.getRoles());
            Cookie cookie = new Cookie("token", token);
            cookie.setHttpOnly(true);
            cookie.setPath("/");

            res.addCookie(cookie);
            return new ResponseEntity<>(userDto.getUserId(), HttpStatus.OK);
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    // check
    @GetMapping("/check")
    public ResponseEntity check(@CookieValue(value = "token", required = false) String token) {
        Claims claims = tokenProvider.parseClaims(token);

        if(claims != null) {
            Long id = Long.parseLong(claims.get("id").toString());
            return new ResponseEntity<>(id, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    // 회원 단건 조회
    @GetMapping("/{userId}")
    public ResponseEntity<ResponseUser> getUser(@PathVariable("userId") Long userId) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(
                        ResponseUser.fromDto(
                                userService.getUserByUserId(userId)
                        )
                );
    }
}