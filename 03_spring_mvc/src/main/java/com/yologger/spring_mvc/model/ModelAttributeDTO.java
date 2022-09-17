package com.yologger.spring_mvc.model;

public class ModelAttributeDTO {
    private String name;
    private String age;

    public ModelAttributeDTO(String name, String age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }
}
