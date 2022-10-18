package com.stackroute.gymownerservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code= HttpStatus.NOT_FOUND, reason="Gym Name not available")
public class GymNameNotAvailable extends Exception {
    public GymNameNotAvailable(String name) {
        super("Gym Name '" + name + "' not registered into the system.");
    }
}
