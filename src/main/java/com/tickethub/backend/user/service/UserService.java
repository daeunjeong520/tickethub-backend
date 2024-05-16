package com.tickethub.backend.user.service;

import com.tickethub.backend.user.dto.UserDto;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService{

    UserDto createUser(String email, String username, String pwd);

    UserDto getUserByUserId(Long userId);
    List<UserDto> getUserByAll();

    UserDto getUserDetailsByEmail(String email);
}
