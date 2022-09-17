package com.yologger.spring_docker;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("/test1")
    String test1() {
        return "test1";
    }

    @GetMapping("/test2")
    String test2() {
        return "test2";
    }

    @GetMapping("/test3")
    String test3() {
        return "test3";
    }
}
