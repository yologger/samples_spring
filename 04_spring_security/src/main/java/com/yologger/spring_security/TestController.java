package com.yologger.spring_security;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

    @GetMapping("/mustache")
    public String mustache() {
        return "test";
    };
}
