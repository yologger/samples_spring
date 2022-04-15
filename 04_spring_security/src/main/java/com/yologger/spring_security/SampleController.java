package com.yologger.spring_security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {
    @GetMapping("/sample")
    String sample() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return "sample";
    }
}
