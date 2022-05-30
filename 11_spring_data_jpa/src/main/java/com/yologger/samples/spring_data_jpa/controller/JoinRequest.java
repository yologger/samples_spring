package com.yologger.samples.spring_data_jpa.controller;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class JoinRequest {
    private String email;
    private String password;

    @Builder
    public JoinRequest(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
