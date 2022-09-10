package com.yologger.spring_webflux;

import lombok.Builder;
import lombok.Getter;

@Getter
public class Member {
    private Long id;
    private String email;
    private String password;

    @Builder
    public Member(Long id, String email, String password) {
        this.id = id;
        this.email = email;
        this.password = password;
    }
}
