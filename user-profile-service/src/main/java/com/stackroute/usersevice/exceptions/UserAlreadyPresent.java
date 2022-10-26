package com.stackroute.usersevice.exceptions;

public class UserAlreadyPresent extends Exception{
    public UserAlreadyPresent(String error){
        super(error);
    }
}
