package com.stackroute.user.authentication.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST,reason = "credentials wrong")
public class MethodArgumentNotValidException extends Exception{
    public MethodArgumentNotValidException()
    {

    }
}
