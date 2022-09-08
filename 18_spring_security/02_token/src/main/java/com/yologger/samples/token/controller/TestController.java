package com.yologger.samples.token.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("/test1")   // 인증만 되면 다 접근 가능
    String test() {
        return "test1";
    }

    @PreAuthorize("hasAnyAuthority('USER', 'ADMIN')")   // 인증 후 'USER', 'ADMIN' 권한을 가져야만 접근 가능
    @GetMapping("/test2")
    String test2() {
        return "test2";
    }

    @PreAuthorize("hasAnyAuthority('USER')")   // 인증 후 'USER' 권한을 가져야만 접근 가능
    @GetMapping("/test3")
    String test3() {
        return "test3";
    }

    @PreAuthorize("hasAnyAuthority('ADMIN')")   // 인증 후 'ADMIN' 권한을 가져야만 접근 가능
    @GetMapping("/test4")
    String test4() {
        return "test4";
    }
}
