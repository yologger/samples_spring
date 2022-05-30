package com.yologger.security.session.service;

import com.yologger.security.session.model.RegistrationDto;
import com.yologger.security.session.repository.AuthorityType;
import com.yologger.security.session.repository.UserEntity;
import com.yologger.security.session.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    @Autowired
    PasswordEncoder passwordEncoder;

    private final UserRepository userRepository;

    public Long register(RegistrationDto request) {
        UserEntity user = UserEntity.builder()
                .name(request.getName())
                .authority(AuthorityType.USER)
                .password(passwordEncoder.encode(request.getPassword()))
                .build();

        UserEntity saved = userRepository.save(user);
        return saved.getId();
    }
}
