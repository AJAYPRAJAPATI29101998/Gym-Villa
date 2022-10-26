package com.stackroute.feedbackreviewservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND,reason = "review not exists with this id ")
public class ReviewNotFoundException extends Exception {
    public ReviewNotFoundException(String review_not_exists) {
    }
}
