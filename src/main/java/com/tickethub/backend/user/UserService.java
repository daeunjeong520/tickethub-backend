package com.tickethub.backend.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    // 회원가입
    @Transactional
    public UserDto signup(String loginId, String loginPw, String username, String nickname) {
        User user = User.builder()
                .loginId(loginId)
                .loginPw(loginPw)
                .username(username)
                .nickname(nickname)
                .build();

        User savedUser = userRepository.save(user);
        return UserDto.from(savedUser);
    }

    // 로그인
    @Transactional
    public UserDto login(String loginId, String loginPw) {
        User user = userRepository.findByLoginId(loginId)
                .orElseThrow(() -> new IllegalStateException("일치하는 회원이 없습니다"));

        if(!user.getLoginPw().equals(loginPw)) {
            throw new IllegalStateException("비밀번호가 일치하지 않습니다");
        }
        return UserDto.from(user);
    }
}