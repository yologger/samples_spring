package com.yologger.app;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class MailManager {
    void sendEmail() {
        System.out.println("sendEmail()");
    }
}
