package com.yologger.kafka.kafka_consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class KafkaConsumerService {

    @KafkaListener(topics = "a-topic", groupId = "a-consumer-group")
    public void consume(String message) throws IOException {
        System.out.println("Consume message: " + message);
    }
}
