package com.ab.user.service.exceptions;

public class ResourceNotFundException extends RuntimeException {
    public ResourceNotFundException(){
        super("Resource Not Fund On Sever!!");
    }

    public ResourceNotFundException(String message){
        super(message);
    }
}
