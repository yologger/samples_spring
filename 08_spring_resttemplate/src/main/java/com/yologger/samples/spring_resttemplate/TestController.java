package com.yologger.samples.spring_resttemplate;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("/test")
    public String test() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://93b8a13e-6e54-42b0-80a5-ca143fc9addb.mock.pstmn.io/test/get";
        // ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        ResponseEntity<MyResponse> response = restTemplate.getForEntity(url, MyResponse.class);
        HttpStatus httpStatus = response.getStatusCode();
        MyResponse result = response.getBody();
        HttpHeaders headers = response.getHeaders();
        headers.getContentType();
        return "ok";
    }
}
