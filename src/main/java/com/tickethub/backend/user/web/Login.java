package com.tickethub.backend.user.web;

import com.tickethub.backend.user.UserDto;
import lombok.*;

public class Login {

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    static class Request {
        private String loginId;
        private String loginPw;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    static class Response {

        private Long userId;
        private String username;
        private String nickname;

        public static Response from(UserDto userDto) {
            return Response.builder()
                    .userId(userDto.getUserId())
                    .username(userDto.getUsername())
                    .nickname(userDto.getNickname())
                    .build();
        }
    }
}