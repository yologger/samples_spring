package com.yologger.samples.spring_test.controller;

import com.yologger.samples.spring_test.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")

public class TestController {

    @Autowired
    TestService testService;

    @GetMapping
    @RequestMapping("/test")
    public String test() {
        return testService.test();
        // return "test";
    }
}
