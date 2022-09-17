package com.yologger.redis_subscriber;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class RedisSubscriber implements MessageListener {
    @Override
    public void onMessage(Message message, byte[] pattern) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            ChatMessage chatMessage = mapper.readValue(message.getBody(), ChatMessage.class);
            System.out.println("sender: " + chatMessage.getSender());
            System.out.println("context: " + chatMessage.getContext());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
