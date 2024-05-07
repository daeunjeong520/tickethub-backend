package com.tickethub.backend.user.web;

import com.tickethub.backend.user.UserDto;
import com.tickethub.backend.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    // 회원가입
    @PostMapping("/signup")
    public SignUp.Response signup(@RequestBody SignUp.Request request) {
        UserDto userDto = userService.signup(
                request.getLoginId(),
                request.getLoginPw(),
                request.getUsername(),
                request.getNickname()
        );
        return SignUp.Response.from(userDto);
    }

    // 로그인
    @PostMapping("/login")
    public Login.Response login(@RequestBody Login.Request request) {
        UserDto userDto = userService.login(
                request.getLoginId(),
                request.getLoginPw()
        );
        return Login.Response.from(userDto);
    }
}
