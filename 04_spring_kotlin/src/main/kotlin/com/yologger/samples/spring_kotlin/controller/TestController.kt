package com.yologger.samples.spring_kotlin.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/test")
class TestController {
    @GetMapping
    @RequestMapping("/test1")
    fun test1(): String {
        return "test1"
    }
}