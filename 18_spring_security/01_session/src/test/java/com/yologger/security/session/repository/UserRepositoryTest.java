package com.yologger.security.session.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class UserRepositoryTest {

    @Autowired UserRepository userRepository;

    @Test
    public void test() {
        UserEntity user = UserEntity.builder()
                .name("paul")
                .password("1234")
                .authority(AuthorityType.USER)
                .build();

        userRepository.save(user);

        Optional<UserEntity> saved = userRepository.findOneByName(user.getName());
        assertThat(saved.get().getName()).isEqualTo(user.getName());
        assertThat(saved.get().getId()).isNotNull();
    }
}