package com.yologger.app;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        MailManager manager = ctx.getBean("mailManager", MailManager.class);
        manager.sendEmail();
    }
}
