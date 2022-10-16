package com.stackroute.bookingservice.advice;

import com.stackroute.bookingservice.exceptions.DataNotPresentException;
import com.stackroute.bookingservice.exceptions.SameEntryException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GymAdvice {

    @ExceptionHandler(SameEntryException.class)
    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    public String noDubliceData(SameEntryException sameEntryException){
        return sameEntryException.getMessage();
    }

    @ExceptionHandler(DataNotPresentException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String noDataAvailable(DataNotPresentException dataNotPresentException){
        return dataNotPresentException.getMessage();
    }

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

}
