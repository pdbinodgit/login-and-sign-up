package com.loginandsignup.loginandsinup.customresponse;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class Response<T> {

    private String message;

    private int code;

    private HttpStatus status;

    private T data;

    public Response(String message, int code, HttpStatus status, T data) {
        this.message = message;
        this.code = code;
        this.status = status;
        this.data = data;
    }

    public Response(String message) {
        this.message = message;
        this.code = 400;
        this.status = HttpStatus.BAD_REQUEST;
    }

    public Response(String message,T date){
        this.message=message;
        this.code=200;
        this.data=date;
        this.status=HttpStatus.OK;
    }
}
