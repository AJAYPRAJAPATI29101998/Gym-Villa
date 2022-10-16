package com.stackroute.bookingservice.exceptions;

public class SameEntryException extends Exception{
    public SameEntryException(String detail){
        super(detail);
    }
}
