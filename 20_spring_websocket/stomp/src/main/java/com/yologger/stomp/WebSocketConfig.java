package com.yologger.stomp;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/ws").setAllowedOrigins("*");
        // registry.addEndpoint("/websocket").withSockJS();
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        // Send Endpoint
        registry.setApplicationDestinationPrefixes("/publish");

        // In-memory Message Broker
        // SimpleBroker는 Spring WebSocket 모듈에서 제공하는 인메모리 방식의 내장 Message Broker
        registry.enableSimpleBroker("/subscribe");

        // Redis, Kafka 같은 외부 Message Broker
        // registry.enableStompBrokerRelay()
    }
}
