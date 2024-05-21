package com.tickethub.backend.user.service;

import com.tickethub.backend.user.dto.UserDto;
import com.tickethub.backend.user.persist.UserEntity;
import com.tickethub.backend.user.persist.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found"));
    }

    /**
     * 회원가입
     */
    @Transactional
    @Override
    public UserDto createUser(String email, String username, String pwd, List<String> roles) {
        boolean exists = userRepository.existsByEmail(email);
        if(exists) {
            throw new IllegalStateException("Duplicate email");
        }

        UserEntity userEntity = UserEntity.builder()
                .username(username)
                .email(email)
                .encryptedPwd(passwordEncoder.encode(pwd)) // password encode
                .roles(roles)
                .build();

        // 회원가입
        return UserDto.from(userRepository.save(userEntity));
    }

    /**
     * 로그인
     */
    @Transactional
    @Override
    public UserDto loginUser(String email, String password) {
        // 패스워드 검증
        UserEntity userEntity = userRepository.findByEmail(email)
                .orElseThrow(() -> new IllegalStateException("User not found"));

        if(!passwordEncoder.matches(password, userEntity.getPassword())) {
            throw new IllegalStateException("Invalid password");
        }
        return UserDto.from(userEntity);
    }

    // 유저 조회(by userId)
    @Override
    public UserDto getUserByUserId(Long userId) {
        UserEntity userEntity = userRepository.findByUserId(userId)
                .orElseThrow(() -> new IllegalArgumentException("User Not Found"));

        return UserDto.from(userEntity);
    }

    @Override
    public UserDto getUserDetailsByEmail(String email) {
        UserEntity userEntity = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("user not found"));

        return UserDto.from(userEntity);
    }

    // 유저 전체 조회
    @Override
    public List<UserDto> getUserByAll() {
        return userRepository.findAll()
                .stream()
                .map(UserDto::from)
                .collect(Collectors.toList());
    }
}
