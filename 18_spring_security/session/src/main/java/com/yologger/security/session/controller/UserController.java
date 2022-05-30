package com.yologger.security.session.controller;

import com.yologger.security.session.model.RegistrationDto;
import com.yologger.security.session.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/user/registration")
    public String registrationPage() {
        return "registration";
    }

    @PostMapping("/user/registration")
    public String registration(RegistrationDto request) {
        userService.register(request);
        return "redirect:/login";
    }
}
