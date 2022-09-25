package com.yologger.stomp;

import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class MessageController {

    private final SimpMessageSendingOperations messageSendingOperations;

    @MessageMapping("/message")
    public void message(ChatMessage message) throws Exception {
        messageSendingOperations.convertAndSend("/subscribe/room/" + message.getRoomId(), message);
    }
}
