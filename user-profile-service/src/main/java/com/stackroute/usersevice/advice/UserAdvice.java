package com.stackroute.usersevice.advice;

import com.stackroute.usersevice.exceptions.UserAlreadyPresent;
import com.stackroute.usersevice.exceptions.UserNotPresent;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class UserAdvice {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }

    @ExceptionHandler(UserNotPresent.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String userNotPresent(UserNotPresent userNotPresent){
        return userNotPresent.getMessage();
    }

    @ExceptionHandler(UserAlreadyPresent.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public String userAlreadyPresent(UserAlreadyPresent userAlreadyPresent){
        return userAlreadyPresent.getMessage();
    }

}
