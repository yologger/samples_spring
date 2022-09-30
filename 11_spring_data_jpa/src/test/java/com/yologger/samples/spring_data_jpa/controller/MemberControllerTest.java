package com.yologger.samples.spring_data_jpa.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yologger.samples.spring_data_jpa.repository.MemberRepository;
import com.yologger.samples.spring_data_jpa.service.MemberService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import javax.persistence.EntityManager;
import java.util.HashMap;
import java.util.Map;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(MemberController.class)
class MemberControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    MemberService memberService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void test() throws Exception {

        // Given
        Long dummyId = 1L;
        when(memberService.join(any())).thenReturn(dummyId);

        Map<String, String> body = new HashMap<>();
        body.put("email", "smith@gmail.com");
        body.put("password", "1234");

        mvc.perform(post("/member/join")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(body)))
                .andExpect(status().isCreated())
                .andDo(print());
    }
}