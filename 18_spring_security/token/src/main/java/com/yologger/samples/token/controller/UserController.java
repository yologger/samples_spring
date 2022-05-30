package com.yologger.samples.token.controller;

import com.yologger.samples.token.model.RegisterRequestDto;
import com.yologger.samples.token.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/user/registration")
    public ResponseEntity<Long> register(@RequestBody RegisterRequestDto request) {
        return new ResponseEntity(userService.register(request), HttpStatus.CREATED);
    }
}
