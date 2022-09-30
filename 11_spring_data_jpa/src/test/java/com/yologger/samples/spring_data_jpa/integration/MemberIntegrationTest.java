package com.yologger.samples.spring_data_jpa.integration;

import com.yologger.samples.spring_data_jpa.model.JoinRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MemberIntegrationTest {

    @Autowired
    TestRestTemplate template;

    @LocalServerPort
    private int port;   // 랜덤한 포트가 주입된다.

    @Test
    void joinTest() {
        String dummyEmail = "ronaldo@gmail.com";
        String dummyPassword = "1234";
        JoinRequest request = JoinRequest.builder()
                .email(dummyEmail)
                .password(dummyPassword)
                .build();

        ResponseEntity<Long> id = template.postForEntity("/member/join", request, Long.class);
        assertThat(id).isNotNull();
    }
}
