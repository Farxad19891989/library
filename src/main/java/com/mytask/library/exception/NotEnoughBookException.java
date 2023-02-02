package com.mytask.library.exception;

public class NotEnoughBookException extends RuntimeException{
    String message;
    public NotEnoughBookException(String message){
        super(message);
        this.message=message;
    }
}
