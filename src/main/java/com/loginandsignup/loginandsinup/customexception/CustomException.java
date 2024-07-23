package com.loginandsignup.loginandsinup.customexception;

import org.springframework.http.HttpStatus;

public class CustomException extends RuntimeException{

    private String message;

    private int code;

    private HttpStatus status;

    public CustomException( String message, int code, HttpStatus status) {

        this.message = message;
        this.code = code;
        this.status = status;
    }
}
