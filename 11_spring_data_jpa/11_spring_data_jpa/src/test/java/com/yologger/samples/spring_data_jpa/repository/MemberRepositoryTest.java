package com.yologger.samples.spring_data_jpa.repository;

import org.h2.tools.Server;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.sql.SQLException;
import java.util.List;

import static com.google.common.truth.Truth.assertThat;

@DataJpaTest
class MemberRepositoryTest {
    @Autowired MemberRepository memberRepository;

    @Test
    public void test() {
        MemberEntity member = MemberEntity.builder()
                .email("ronaldo@gmail.com")
                .name("Cristiano Ronaldo")
                .password("1234")
                .build();

        memberRepository.save(member);


        assertThat(memberRepository.count()).isEqualTo(1);
    }
}












