package com.yolgger.spring.samples.webflux_websocket_java.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.socket.WebSocketHandler;
import org.springframework.web.reactive.socket.WebSocketMessage;
import org.springframework.web.reactive.socket.WebSocketSession;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@Slf4j
public class TestHandler implements WebSocketHandler {
    Repository repository = new Repository();

    @Override
    public Mono<Void> handle(WebSocketSession session) {

        Flux<WebSocketMessage> out = session.receive()
                .doOnSubscribe(subscription -> {
                    log.info("Connected");
                })
                .doOnNext(message -> {
                    log.info("message: " + message.getPayloadAsText());
                })
                .doOnError(error -> {

                })
                .doOnComplete(() -> {
                    log.info("Disconnected");
                })
                .concatMap((message) -> repository.getUser())
                .map(user -> session.textMessage("Echo: " + user.name + " " + user.age));

        return session.send(out);
    }
}

class Repository {
    Flux<User> getUser() {
        return Flux.just(
                new User("Paul", 34),
                new User("Paul", 34)
        );
    }
}

class User {
    String name;
    int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
