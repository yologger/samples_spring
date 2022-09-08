package com.yologger.samples.token.service;

import com.yologger.samples.token.model.RegisterRequestDto;
import com.yologger.samples.token.repository.AuthorityType;
import com.yologger.samples.token.repository.UserEntity;
import com.yologger.samples.token.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final PasswordEncoder passwordEncoder;

    private final UserRepository userRepository;

    public Long register(RegisterRequestDto request) {

        UserEntity user = UserEntity.builder()
                .name(request.getName())
                .authority(AuthorityType.USER)
                .password(passwordEncoder.encode(request.getPassword()))
                .build();

        UserEntity saved = userRepository.save(user);
        return saved.getId();
    }
}