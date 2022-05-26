package com.yologger.spring_security.repository;

public enum RoleEnum {

    ROLE_ADMIN("ADMIN"),
    ROLE_USER("USER");

    private String description;

    RoleEnum(String description) {
        this.description = description;
    }
}
