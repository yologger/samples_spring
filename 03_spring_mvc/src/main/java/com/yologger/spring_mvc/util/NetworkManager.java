package com.yologger.spring_mvc.util;

public class NetworkManager {
    private String endpoint;

    public NetworkManager(String endpoint) {
        this.endpoint = endpoint;
    }

    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }
}
