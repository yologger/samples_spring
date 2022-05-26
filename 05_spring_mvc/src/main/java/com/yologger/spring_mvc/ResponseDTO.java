package com.yologger.spring_mvc;

public class ResponseDTO {
    private String name;
    private int age;

    public ResponseDTO(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
