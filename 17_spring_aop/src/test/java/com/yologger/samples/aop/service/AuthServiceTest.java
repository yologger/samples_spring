package com.yologger.samples.aop.service;

import com.yologger.samples.aop.AuthService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AuthServiceTest {
    @Autowired
    AuthService authService;

    @Test
    public void loginTest() {
        authService.join("paul", "1234");
    }
}