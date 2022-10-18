package com.stackroute.gymownerservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.NOT_FOUND, reason="Gym ID not available")
public class GymIdNotAvailable extends Exception {
    public GymIdNotAvailable(int id) {
        super("Gym ID '" + id + "' not registered into the system.");
    }
}
