package com.yologger.spring_mvc.config;

import com.yologger.spring_mvc.util.NetworkManager;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:network.properties")
public class NetworkConfig {

    @Value("${network.endpoint}")
    private String endpoint;

    @Bean
    public NetworkManager networkManager() {
        return new NetworkManager(endpoint);
    }
}
