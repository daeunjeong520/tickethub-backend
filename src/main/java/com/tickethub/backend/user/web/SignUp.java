package com.tickethub.backend.user.web;

import com.tickethub.backend.user.UserDto;
import lombok.*;

public class SignUp {

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    static class Request {

        private String loginId;
        private String loginPw;
        private String username;
        private String nickname;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    static class Response {
        private Long userId;
        private String loginId;
        private String username;
        private String nickname;

        public static Response from(UserDto userDto) {
            return Response.builder()
                    .userId(userDto.getUserId())
                    .loginId(userDto.getLoginId())
                    .username(userDto.getUsername())
                    .nickname(userDto.getNickname())
                    .build();
        }
    }
}