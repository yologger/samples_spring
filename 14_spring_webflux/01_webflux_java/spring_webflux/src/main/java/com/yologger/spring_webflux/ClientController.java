package com.yologger.spring_webflux;

import org.springframework.http.MediaType;
import org.springframework.http.codec.ServerSentEvent;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.time.LocalTime;
import java.util.Date;
import java.util.Random;

@RestController
@RequestMapping("/stock")
public class ClientController {

    @GetMapping
    @RequestMapping(
            value = "/microsoft",
            produces = MediaType.TEXT_EVENT_STREAM_VALUE
    )
    public Flux<Stock> get() {

        Random random = new Random();

        return Flux.interval(Duration.ofSeconds(1))
                .map(it -> new Stock("Microsoft", random.nextInt(101), random.nextInt(101), new Date()));
    }
}