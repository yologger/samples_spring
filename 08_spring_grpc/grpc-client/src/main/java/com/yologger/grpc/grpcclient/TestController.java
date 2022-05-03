package com.yologger.grpc.grpcclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired GrpcClientService service;

    @GetMapping("/test")
    String doTest() {
        return service.doTest("This is data from client");
    }
}
