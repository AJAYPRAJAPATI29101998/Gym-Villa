package com.stackroute.emailservice.emailadvice;

import com.stackroute.emailservice.exception.BookingIdNotFoundException;
import com.stackroute.emailservice.exception.MailNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class EmailAdvice {

    @ExceptionHandler(MailNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String noEmail(MailNotFoundException mailNotFoundException){
        return mailNotFoundException.getMessage();
    }

    @ExceptionHandler(BookingIdNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String noBookingId(BookingIdNotFoundException bookingIdNotFoundException){
        return bookingIdNotFoundException.getMessage();
    }
}
