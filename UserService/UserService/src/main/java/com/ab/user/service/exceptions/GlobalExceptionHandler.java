package com.ab.user.service.exceptions;

import com.ab.user.service.payloads.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFundException.class)
    public ResponseEntity<ApiResponse> handleResourceNotFoundException(ResourceNotFundException ex){
       String message = ex.getMessage();
       ApiResponse response = ApiResponse.builder().message(message).success(true).status(HttpStatus.NOT_FOUND).build();
       return new ResponseEntity<ApiResponse>(response,HttpStatus.NOT_FOUND);
    }
}
