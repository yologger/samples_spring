package com.yologger.spring_mvc.config;

import com.yologger.spring_mvc.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
public class MyConfig implements WebMvcConfigurer {

    @Bean("smith")
    public Person smith() {
        return new Person("Smith", 34);
    }
}
