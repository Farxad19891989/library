package com.mytask.library.exception;


import com.mytask.library.model.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = LibreriianAlreadyExist.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleExceptionLibrerianAlreadyExist(LibreriianAlreadyExist ex){
        return new ErrorResponse(HttpStatus.BAD_REQUEST.value(),ex.getMessage());
    }

    @ExceptionHandler(value = WrongCredintialsException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleExceptionWrongCredintials(WrongCredintialsException ex){
        return new ErrorResponse(HttpStatus.BAD_REQUEST.value(),ex.getMessage());
    }

    @ExceptionHandler(value = BookNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleExceptionBookNotFound(BookNotFoundException ex){
        return new ErrorResponse(HttpStatus.NOT_FOUND.value(),ex.getMessage());
    }

    @ExceptionHandler(value = NotEnoughBookException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleExceptionBookNotFound(NotEnoughBookException ex){
        return new ErrorResponse(HttpStatus.BAD_REQUEST.value(),ex.getMessage());
    }

    @ExceptionHandler(value = ReaderNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleExceptionReaderNotFound(ReaderNotFoundException ex){
        return new ErrorResponse(HttpStatus.BAD_REQUEST.value(),ex.getMessage());
    }
}
