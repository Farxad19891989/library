package com.mytask.library.exception;

public class LibreriianAlreadyExist extends RuntimeException{

    private String message;

    public LibreriianAlreadyExist(String message){
        super(message);
        this.message=message;
    }

}
