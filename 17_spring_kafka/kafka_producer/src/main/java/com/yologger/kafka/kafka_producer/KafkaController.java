package com.yologger.kafka.kafka_producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafka")
public class KafkaController {
    @Autowired KafkaProducerService service;

    @GetMapping("/send")
    public void kafka() {
        service.sendMessage("Test message");
    }
}
