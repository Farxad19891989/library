package com.mytask.library.exception;

public class ReaderNotFoundException extends RuntimeException{
    String message;
    public ReaderNotFoundException(String message){
        super(message);
        this.message=message;
    }

}
