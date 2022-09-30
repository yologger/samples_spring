package com.yologger.samples.spring_data_jpa.service;

import com.yologger.samples.spring_data_jpa.model.JoinRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
class MemberServiceTest {

    @Autowired
    private MemberService memberService;

    @Test
    @Transactional
    public void test() {
        JoinRequest request = JoinRequest.builder()
                .email("paul@gmail.com")
                .password("1234")
                .build();
        Long id = memberService.join(request);
        assertThat(id).isNotZero();
    }
}