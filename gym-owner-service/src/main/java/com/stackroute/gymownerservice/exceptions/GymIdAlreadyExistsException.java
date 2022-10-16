package com.stackroute.gymownerservice.exceptions;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.http.HttpStatus;

public class GymIdAlreadyExistsException extends Exception {

    public GymIdAlreadyExistsException(int id) {
        super("Gym ID '" + id + "' selected already exists, please use different Gym ID.");
    }

    /*@Data
    @RequiredArgsConstructor
    public class Error {
        private final HttpStatus httpStatus;
        private final String message;
    }

    @ExceptionHandler(GymIdAlreadyExistsException.class)
    public ResponseEntity<Error> handleException(GymIdAlreadyExistsException e) {
        Error error = new Error(HttpStatus.NOT_FOUND, e.getLocalizedMessage());
        return new ResponseEntity<>(error, error.getHttpStatus());
    }*/
}
