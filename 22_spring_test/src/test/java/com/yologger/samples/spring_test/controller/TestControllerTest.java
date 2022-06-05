package com.yologger.samples.spring_test.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import javax.servlet.http.Cookie;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest
public class TestControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void test1() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/test1"))
                .andExpect(status().isOk())
                .andExpect(content().string("test1"))
                .andDo(print());
    }

    @Test
    public void test2() throws Exception {
        String name = "John";
        String nation = "USA";
        mvc.perform(MockMvcRequestBuilders.get("/test2/{name}/{nation}", name, nation))
                .andExpect(status().isOk())
                .andExpect(content().string("test2" + name + nation))
                .andDo(print());
    }

    @Test
    public void test3() throws Exception {
        String name = "John";
        String nation = "USA";
        String token = "Bearer werjklwerjweklrjlkwer";

        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("name", name);
        params.add("nation", nation);

        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.AUTHORIZATION, token);

        mvc.perform(MockMvcRequestBuilders.get("/test3")
                .headers(headers)
                .params(params)
                .cookie(new Cookie("key", "value"))
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(header().string(HttpHeaders.AUTHORIZATION, token))
        .andExpect(content().string(name+nation))
        .andDo(print());
    }

    @Test
    public void test4() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/test4"))
                .andExpect(jsonPath("$.name", is("paul")))
                .andExpect(jsonPath("$.nation", is("USA")))
                .andDo(print());
    }

    @Test
    public void test5() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/test5"))
                .andExpect(jsonPath("$[0].name", is("ronaldo")))
                .andExpect(jsonPath("$[1].nation", is("korea")))
                .andExpect(jsonPath("$[2]").exists())
                .andExpect(jsonPath("$[3]").doesNotExist())
                .andDo(print());
    }

    @Test
    public void test6() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/test6"))
                .andExpect(jsonPath("$.people[0].name", is("paul")))
                .andExpect(jsonPath("$.people[2].nation", is("Spain")))
                .andExpect(jsonPath("$.people[0]").exists())
                .andExpect(jsonPath("$.people[3]").doesNotExist())
                .andDo(print());

    }
}