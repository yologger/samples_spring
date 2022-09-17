package com.yologger.spring_mvc;

import com.yologger.spring_mvc.model.RequestDTO;
import com.yologger.spring_mvc.model.ResponseDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;

import java.net.URI;

import static com.google.common.truth.Truth.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ApplicationTests {

    @Autowired
    TestRestTemplate template;

    @LocalServerPort
    private int port;

    @Test
    public void test() {
        RequestDTO body = new RequestDTO("Paul", 35);

        HttpHeaders headers= new HttpHeaders();
        headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);
        headers.add("Content-type", MediaType.APPLICATION_JSON_VALUE);

        URI url = URI.create("http://localhost:" + port + "/test/test1");

        RequestEntity<RequestDTO> request = new RequestEntity(body, headers, HttpMethod.POST, url);

        ResponseEntity<ResponseDTO> response = template.exchange(request, ResponseDTO.class);

        assertThat(response.getBody().getName()).isEqualTo("Paul");
        assertThat(response.getBody().getAge()).isEqualTo(34);
    }
}