package com.stackroute.user.authentication.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT,reason = "user alredy exists")
public class UserAlreadyExist extends Throwable {
    public UserAlreadyExist() {

    }
}
