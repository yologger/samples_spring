package com.yologger.samples.spring_data_jpa.service;

import com.yologger.samples.spring_data_jpa.controller.JoinRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;

import javax.transaction.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@TestPropertySource("classpath:h2-datasource.properties")
class MemberServiceTest {

    @Autowired
    private MemberService memberService;

    @Test
    public void test() {
        JoinRequest request = JoinRequest.builder()
                .email("paul@gmail.com")
                .password("1234")
                .build();
        ResponseEntity<Long> response = memberService.join(request);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        assertThat(response.getBody()).isNotZero();
    }
}