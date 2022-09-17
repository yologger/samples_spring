package com.yologger.samples.spring_resttemplate;

import java.io.Serializable;

public class MyResponse implements Serializable {
    private String email;
    private String name;
    private int age;

    public MyResponse() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
