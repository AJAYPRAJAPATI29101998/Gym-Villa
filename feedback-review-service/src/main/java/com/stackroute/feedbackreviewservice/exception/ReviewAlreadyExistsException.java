package com.stackroute.feedbackreviewservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT,reason = "Review already exists")
public class ReviewAlreadyExistsException extends Exception {
    public ReviewAlreadyExistsException(String review_already_exists) {
    }

//    @ResponseStatus(value = HttpStatus.CONFLICT,reason = "user alredy exists")
//    public class UserAlreadyExist extends Throwable {
//        public UserAlreadyExist() {

        }


