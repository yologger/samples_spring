package com.yologger.samples.spring_data_jpa.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

import static com.google.common.truth.Truth.assertThat;

@DataJpaTest
class MemberRepositoryTest {
    @Autowired MemberRepository memberRepository;

    @Test
    public void test() {
        MemberEntity member = MemberEntity.builder()
                .email("ronaldo@gmail.com")
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












