package com.yologger.spring_webflux;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.test.web.reactive.server.WebTestClient;

@WebFluxTest
class ApplicationTests {

    @Autowired
    private WebTestClient webClient;

    @Test
    void test() {
        webClient.get()
                .uri("/client/get")
                .exchange()
                .expectStatus().isOk();
    }
}
