package com.yologger.samples.spring_test.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class TestControllerTest {

    @Value("${test.key1}")
    private String testKey1;

    @Value("${test.key2}")
    private String testKey2;

    @Value("${test.key3}")
    private String testKey3;


    @Test
    public void test() throws Exception {
        assertThat(testKey1).isEqualTo("newValue1");
        assertThat(testKey2).isEqualTo("newValue2");
        assertThat(testKey3).isEqualTo("newValue3");
    }
}