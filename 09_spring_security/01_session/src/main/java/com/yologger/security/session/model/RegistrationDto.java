package com.yologger.security.session.model;

import lombok.Builder;
import lombok.Getter;

@Getter
public class RegistrationDto {
    private String name;
    private String password;

    @Builder
    public RegistrationDto(String name, String password) {
        this.name = name;
        this.password = password;
    }
}
