package com.stackroute.gymownerservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code= HttpStatus.CONFLICT, reason="Gym Name already registered")
public class GymNameAlreadyExistsException extends Exception {

    public GymNameAlreadyExistsException(String name, Integer id) {
        super("Gym Name '" + name + "' already registered into the system with Gym ID '" + id + "'");
    }
}
