package com.yologger.samples.security.auth;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class AuthController {

    @GetMapping("/login")
    public String loginView() {
        return "login";
    }

    @PostMapping("/login")
    public String login() {
        return "redirect:main";
    }

    @GetMapping("/main")
    public String mainView() {
        return "main";
    }
}
