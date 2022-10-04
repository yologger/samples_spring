package com.yologger.spring_redis.repository;

import java.io.Serializable;
import java.util.UUID;

public class Phone {

    // private static final long serialVersionUID = -1L;

    private String id;
    private String name;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Phone(String name) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
    }

    public Phone(String id, String name) {
        this.id = id;
        this.name = name;
    }
}
