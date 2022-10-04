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

        Person from = new Person("Paul", 34);
        Car c1 = new Car("S Class", "Benz");
        Car c2 = new Car("Sonata", "Hyundai");
        from.addCar(c1);
        from.addCar(c2);
        String jsonString = objectMapper.writeValueAsString(from);
        System.out.println(jsonString);  // {"name":"Paul","age":34,"cars":[{"name":"S Class","manufacturer":"Benz"},{"name":"Sonata","manufacturer":"Hyundai"}]}

        Person to = objectMapper.readValue(jsonString, Person.class);

        for (Car car : to.getCars()) {
            System.out.println(car.getName());
        }
    }
}
