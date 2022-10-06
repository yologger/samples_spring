package com.yologger.samples.jackson_objectmapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ApplicationTests {

    @Test
    void test() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();


        String jsonString = "{\"id\":\"1\",\"name\":\"Paul\",\"age\":\"1\"}";
        Person person = objectMapper.readerFor(Person.class).readValue(jsonString);
        System.out.println(person);
    }
}
