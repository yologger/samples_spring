package com.yologger.samples.logback;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    private final Logger log = LoggerFactory.getLogger("MyLogger");

    @GetMapping("/test")
    public String test() {
        log.trace("test");
        log.debug("test");
        log.info("test");
        log.warn("test");
        log.error("test");
        return "test";
    }
}
