package com.yologger.samples.jackson_objectmapper;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Person {

    private String id;
    private String name;
    private int age;

    // 기본 생성자
//    public Person() {
//    }

    @JsonCreator
    public Person(@JsonProperty("id") String id, @JsonProperty("name") String name, @JsonProperty("age")  int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
}
