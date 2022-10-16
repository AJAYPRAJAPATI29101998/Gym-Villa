package com.stackroute.gymownerservice.exceptions;

public class GymNameAlreadyExistsException extends Exception {

    public GymNameAlreadyExistsException(String name, Integer id) {
        super("Gym Name '" + name + "' already registered into the system with Gym ID '" + id + "'");
    }
}
