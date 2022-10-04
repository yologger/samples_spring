package com.yologger.samples.jackson_objectmapper;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class Person {

    private String name;
    private int age;

    private List<Car> cars = new ArrayList<>();

    // 기본 생성자
    public Person() {}

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void addCar(Car car) {
        this.cars.add(car);
    }

    public List<Car> getCars() {
        return this.cars;
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
