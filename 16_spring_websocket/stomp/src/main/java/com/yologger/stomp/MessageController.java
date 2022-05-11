package com.yologger.stomp;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
public class MessageController {
    @MessageMapping("/message")
    @SendTo("/subscribe/room")
    public ResponseDTO greeting(RequestDTO message) throws Exception {
        System.out.println("message: " + message.toString());
        return new ResponseDTO("echo: " + HtmlUtils.htmlEscape(message.getMessage()));
    }
}
