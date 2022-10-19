package com.stackroute.user.authentication.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND,reason = "EmailId and password is not matched")
public class UsernameNotFoundException extends Throwable{
    public UsernameNotFoundException(String emailid_and_password_not_matched){

    }


}
