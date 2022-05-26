package com.yologger.spring_mvc.config;

import com.yologger.spring_mvc.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfig {

    @Bean("smith")
    public Person smith() {
        return new Person("Smith", 34);
    }
}
