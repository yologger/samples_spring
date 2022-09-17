package com.yologger.local_cache.repository;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class MemberRepositoryTest {
    @Autowired
    MemberRepository memberRepository;

    @Test
    @DisplayName("유저 추가 테스트")
    void addUser() {
        String email = "paul@gmail.com";
        String password = "1234";

        MemberEntity memberEntity = MemberEntity.builder()
                .email(email)
                .password(password)
                .build();

        MemberEntity saved = memberRepository.save(memberEntity);
        assertThat(saved.getEmail()).isEqualTo(email);
        assertThat(saved.getPassword()).isEqualTo(password);
    }

    @Test
    @DisplayName("모든 사용자 조회 테스트")
    void findAll() {
        MemberEntity memberEntity1 = MemberEntity.builder()
                .email("paul@gmail.com")
                .password("1234")
                .build();

        MemberEntity memberEntity2 = MemberEntity.builder()
                .email("smith@gmail.com")
                .password("1234")
                .build();

        memberRepository.save(memberEntity1);
        memberRepository.save(memberEntity2);

        List<MemberEntity> users = memberRepository.findAll();
        assertThat(users.size()).isEqualTo(2);
    }
}