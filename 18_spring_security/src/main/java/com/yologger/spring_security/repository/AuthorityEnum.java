package com.yologger.spring_security.repository;

public enum AuthorityEnum {

    CREATE_USER("CREATE_USER"),
    UPDATE_USER("UPDATE_USER"),
    DELETE_USER("DELETE_USER");

    private String description;

    AuthorityEnum(String description) {
        this.description = description;
    }
}
