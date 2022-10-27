package com.stackroute.feedbackreviewservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND,reason = "GynID not exists with this id ")
public class GymIdNotFoundException extends Exception {
    public GymIdNotFoundException(String gym_id_not_found) {
    }
}
