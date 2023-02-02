package com.mytask.library.exception;

public class WrongCredintialsException extends RuntimeException{
    private String message;


    public WrongCredintialsException(String message){
        super(message);
        this.message=message;
    }
}
