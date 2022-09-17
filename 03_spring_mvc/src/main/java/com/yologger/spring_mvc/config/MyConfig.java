package com.yologger.spring_mvc.config;

import com.yologger.spring_mvc.model.PersonDTO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfig {
    @Bean("smith")
    public PersonDTO smith() {
        return new PersonDTO("Smith", 34);
    }
}
