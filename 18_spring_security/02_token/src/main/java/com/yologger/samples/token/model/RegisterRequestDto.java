package com.yologger.samples.token.model;

import lombok.Builder;
import lombok.Getter;

@Getter
public class RegisterRequestDto {
    private String name;
    private String password;

    @Builder
    public RegisterRequestDto(String name, String password) {
        this.name = name;
        this.password = password;
    }
}
