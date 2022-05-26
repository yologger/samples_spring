package com.yologger.spring_mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    Person person;

    @Autowired
    ApplicationContext ctx;

    @GetMapping("/test")
    public String test(@ModelAttribute ModelAttributeDTO modelAttribute, Model model) {
        Person smith = ctx.getBean("smith", Person.class);
        return smith.getName();
    }

    @PostMapping("/test1")
    public ResponseEntity<ResponseDTO> test1(@RequestBody RequestDTO requestDTO) {
        ResponseDTO response = new ResponseDTO(requestDTO.getName(), requestDTO.getAge());
        HttpHeaders headers= new HttpHeaders();
        headers.add("Content-type", "application/json");
        return new ResponseEntity(response, headers, HttpStatus.ACCEPTED);
    }
}
