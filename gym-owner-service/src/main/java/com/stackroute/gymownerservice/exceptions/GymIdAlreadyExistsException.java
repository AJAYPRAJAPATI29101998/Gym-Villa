package com.stackroute.gymownerservice.exceptions;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.CONFLICT, reason="Gym ID already exists")
public class GymIdAlreadyExistsException extends Exception {
    public GymIdAlreadyExistsException(int id) {
        super("Gym ID '" + id + "' selected already exists, please use different Gym ID.");
    }
}
