package com.tickethub.backend.user.service;

import com.tickethub.backend.user.dto.UserDto;
import com.tickethub.backend.user.persist.UserEntity;
import com.tickethub.backend.user.persist.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
    private final BCryptPasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException(email));
        return new User(userEntity.getEmail(), userEntity.getEncryptedPwd(),
                true, true, true, true, new ArrayList<>());
    }

    // 회원가입
    @Transactional
    @Override
    public UserDto createUser(String email, String username, String pwd) {
        UserEntity userEntity = UserEntity.builder()
                .username(username)
                .email(email)
                .encryptedPwd(passwordEncoder.encode(pwd)) // password encode
                .build();

        // user save
        UserEntity savedUser = userRepository.save(userEntity);
        return UserDto.from(savedUser);
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
