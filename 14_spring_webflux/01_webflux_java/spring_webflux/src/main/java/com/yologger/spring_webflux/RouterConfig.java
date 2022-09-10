package com.yologger.spring_webflux;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

@Configuration
public class RouterConfig {

    @Bean
    public RouterFunction<ServerResponse> memberRouter(MemberHandler memberHandler) {
        return RouterFunctions.route()
                .GET("/member/{id}", accept(APPLICATION_JSON), memberHandler::getMemberById)
                .GET("/members", accept(APPLICATION_JSON), memberHandler::getAllMembers)
                .POST("/member", accept(APPLICATION_JSON), memberHandler::addMember)
                .build();
    }
}
