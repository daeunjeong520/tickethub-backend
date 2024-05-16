package com.tickethub.backend.user.dto;

import com.tickethub.backend.user.persist.UserEntity;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {

    private Long userId;
    private String username;
    private String email;
    private String pwd;
    private String encryptedPwd; // 암호화 패스워드

    // entity -> dto
    public static UserDto from(UserEntity user) {
        return UserDto.builder()
                .userId(user.getUserId())
                .username(user.getUsername())
                .email(user.getEmail())
                .build();
    }
}
