package com.stackroute.bookingservice.exceptions;

public class DataNotPresentException extends Exception{
    public DataNotPresentException(String detail){
        super(detail);
    }
}
