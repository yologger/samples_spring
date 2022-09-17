package com.yologger.spring_mvc.controller;

import com.yologger.spring_mvc.model.ModelAttributeDTO;
import com.yologger.spring_mvc.model.PersonDTO;
import com.yologger.spring_mvc.model.RequestDTO;
import com.yologger.spring_mvc.model.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    PersonDTO personDTO;

    @Autowired
    ApplicationContext ctx;

    @GetMapping("/test")
    public String test(@ModelAttribute ModelAttributeDTO modelAttribute, Model model) {
        PersonDTO smith = ctx.getBean("smith", PersonDTO.class);
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
