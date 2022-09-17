package com.yologger.security.session.repository;

public enum AuthorityType {

    ADMIN("ADMIN"),
    USER("USER");

    private String description;

    AuthorityType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
