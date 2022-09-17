package com.yologger.samples.spring_test.controller;

import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.Charset;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@Slf4j
public class TestController {

    @GetMapping("/test")
    public String test() {
        log.trace("This is trace.");
        log.debug("This is debug.");
        log.info("This is info.");
        log.warn("This is warn.");
        log.error("This is error.");
        return "test";
    }

    @GetMapping
    @RequestMapping("/test1")
    public ResponseEntity<String> test1() {
        return ResponseEntity.ok("test1");
    }

    @GetMapping
    @RequestMapping("/test2/{name}/{nation}")
    public ResponseEntity<String> test2(@PathVariable String name, @PathVariable String nation) {
        return ResponseEntity.ok("test2" + name + nation);
    }

    @GetMapping
    @RequestMapping("/test3")
    public ResponseEntity<String> test3(
            @RequestHeader(HttpHeaders.AUTHORIZATION) String authorization,
            @RequestParam String name,
            @RequestParam String nation
    ) {
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.AUTHORIZATION, authorization);

        return new ResponseEntity(name+nation, headers, HttpStatus.OK);
    }

    @GetMapping
    @RequestMapping("/test4")
    public ResponseEntity<Person> test4() {
        Person p = Person.builder()
                .name("paul")
                .nation("USA")
                .build();

        return ResponseEntity.ok(p);
    }

    @GetMapping
    @RequestMapping("/test5")
    public ResponseEntity<List<Person>> test5() {
        List<Person> people = new ArrayList<>(
                Arrays.asList(
                        Person.builder().name("ronaldo").nation("portugal").build(),
                        Person.builder().name("son").nation("korea").build(),
                        Person.builder().name("messi").nation("argentina").build()
                )
        );
        return ResponseEntity.ok(people);
    }

    @GetMapping
    @RequestMapping("/test6")
    public ResponseEntity<JSONObject> test6() {

        HttpHeaders headers = new HttpHeaders();

        JSONArray array = new JSONArray();
        array.add(new Person("paul", "USA"));
        array.add(new Person("smith", "UK"));
        array.add(new Person("john", "Spain"));

        JSONObject body = new JSONObject();
        body.put("people", array);

        return new ResponseEntity(body, headers, HttpStatus.OK);
    }
}
