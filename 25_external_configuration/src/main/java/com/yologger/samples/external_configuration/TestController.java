package com.yologger.samples.external_configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired UserInfoProperties userInfoProperties;

    @GetMapping("/test")
    public String test() {
        return userInfoProperties.getEmail() + userInfoProperties.getName() + userInfoProperties.getAge();
    }
}
