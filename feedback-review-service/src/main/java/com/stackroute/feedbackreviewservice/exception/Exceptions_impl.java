package com.stackroute.feedbackreviewservice.exception;


import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class Exceptions_impl {


    @ExceptionHandler(ReviewAlreadyExistsException .class)
    @ResponseStatus(value = HttpStatus.CONFLICT)
    public String UserAlredyDefoined(ReviewAlreadyExistsException  userAlreadyExist)
    {
        return "review already exists in the DB";
    }


    //    @ExceptionHandler(MethodArgumentNotValidException.class)
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
//        Map<String, String> errors = new HashMap<>();
//        ex.getBindingResult().getAllErrors().forEach((error) -> {
//            String fieldName = ((FieldError) error).getField();
//            String errorMessage = error.getDefaultMessage();
//            errors.put(fieldName, errorMessage);
//        });
//        return (ResponseEntity<Map<String, String>>) errors;
//
//    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;

    }
    @ExceptionHandler(ReviewNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public String ReviewNotPresent(ReviewNotFoundException userAlreadyExist)
    {
        return "review not Exists this this id";
    }

}

