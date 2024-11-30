package com.unik.kursach3.payload;

public class MessageResponse {

    private String message;

    public MessageResponse(String message) {
        this.message = message;
    }

    // Геттери та сеттери
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
