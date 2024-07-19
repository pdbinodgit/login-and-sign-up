package com.loginandsignup.loginandsinup.customexception;

import com.loginandsignup.loginandsinup.customresponse.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<Response<?>> customException(CustomException customException, WebRequest request){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Response<>(customException.getMessage()));
    }

}
