package com.yologger.samples.spring_data_jpa.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

import static com.google.common.truth.Truth.assertThat;

@DataJpaTest
@Sql(scripts = {"classpath:data/dummy.sql"})
class MemberRepositoryTest {
    @Autowired MemberRepository memberRepository;

    @Test
    public void test() {
        List<MemberEntity> members = memberRepository.findAll();
        assertThat(members.size()).isEqualTo(3);
    }
}












