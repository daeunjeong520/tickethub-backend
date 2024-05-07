package com.tickethub.backend.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {

    private Long userId;
    private String loginId;
    private String loginPw;
    private String username;
    private String nickname;

    public static UserDto from(User user) {
        return UserDto.builder()
                .userId(user.getUserId())
                .loginId(user.getLoginId())
                .loginPw(user.getLoginPw())
                .username(user.getUsername())
                .nickname(user.getNickname())
                .build();
    }
}
