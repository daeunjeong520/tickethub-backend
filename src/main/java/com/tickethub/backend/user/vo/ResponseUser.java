package com.tickethub.backend.user.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.tickethub.backend.user.dto.UserDto;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseUser {

    private String email;
    private String username;
    private Long userId;
    private List<String> roles;

    // dto -> response
    public static ResponseUser fromDto(UserDto userDto) {
        return ResponseUser.builder()
                .email(userDto.getEmail())
                .username(userDto.getUsername())
                .userId(userDto.getUserId())
                .roles(userDto.getRoles())
                .build();
    }
}