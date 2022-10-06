package com.yolgger.redis_publisher;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class RedisController {
    private final RedisPublisher redisPublisher;

    @PostMapping("/publish")
    public String publish(@RequestBody ChatMessage chatMessage) {
        redisPublisher.sendMessage(chatMessage);
        return "success";
    }
}