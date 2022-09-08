package com.yologger.spring_redis.repository;

import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.web.bind.annotation.GetMapping;

@RedisHash("person")
@Getter
public class Person {
    @Id
    String id;
    String email;
    String name;
    String password;

    @Builder
    public Person(String email, String name, String password) {
        this.email = email;
        this.name = name;
        this.password = password;
    }
}
