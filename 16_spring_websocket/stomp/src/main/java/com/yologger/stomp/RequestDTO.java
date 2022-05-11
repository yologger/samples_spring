package com.yologger.stomp;

public class RequestDTO {

    private String message;

    public RequestDTO() {
    }

    public RequestDTO(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}