package com.yologger.spring_mvc;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("/test")
    public String test() {
        return "test";
    }

    @GetMapping("/get")
    public ResponseEntity<Person> get(HttpServletRequest request, HttpServletResponse response) {
        Person p = new Person("Paul", 35);
        return ResponseEntity.ok().body(p);
    }

}
