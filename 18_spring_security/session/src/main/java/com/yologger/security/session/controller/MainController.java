package com.yologger.security.session.controller;

import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class MainController {

    @GetMapping("/")
    public String home() {
        return "home";
    }
}
