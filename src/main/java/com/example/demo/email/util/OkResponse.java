package com.example.demo.email.util;

import lombok.Data;

@Data
public class OkResponse {
    private String message;

    public OkResponse() {
        this.message = "OK";
    }
}
