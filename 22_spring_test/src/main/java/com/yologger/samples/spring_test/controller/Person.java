package com.yologger.samples.spring_test.controller;

import lombok.Builder;
import lombok.Getter;

@Getter
public class Person {
    private String name;
    private String nation;

    @Builder
    public Person(String name, String nation) {
        this.name = name;
        this.nation = nation;
    }
}
