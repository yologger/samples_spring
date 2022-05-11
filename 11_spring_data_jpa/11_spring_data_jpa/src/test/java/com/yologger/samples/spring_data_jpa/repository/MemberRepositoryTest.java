package com.yologger.samples.spring_data_jpa.repository;

import org.h2.tools.Server;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.Commit;
import org.springframework.test.annotation.Rollback;
import org.springframework.web.client.RestTemplate;

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

//        Sort sort1 = Sort.by("age").ascending();
//        Sort sort2 = Sort.by("name").descending();
//        Sort sortAll = sort1.and(sort2);
//        List<MemberEntity> members = memberRepository.findAll(sortAll);

        Pageable pageable = PageRequest.of(0, 10);
        Page<MemberEntity> page = memberRepository.findAll(pageable);

        List<MemberEntity> members = page.getContent();
        int totalPages = page.getTotalPages();
        long totalElements = page.getTotalElements();
        page.isEmpty();
        page.isFirst();
        page.isLast();


        assertThat(memberRepository.count()).isEqualTo(1);
    }
}












