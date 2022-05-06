package com.yologger.project.repository.member;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;

    @AfterEach
    public void tearDown() {
        memberRepository.deleteAll();
    }

    @Test
    public void test() {
        MemberEntity member = MemberEntity.builder()
                .email("paul@gmail.com")
                .name("paul")
                .nation("Portugal")
                .password("1234")
                .build();

        MemberEntity saved = memberRepository.save(member);

        assertThat(saved.getEmail()).isEqualTo("paul@gmail.com");
    }
}