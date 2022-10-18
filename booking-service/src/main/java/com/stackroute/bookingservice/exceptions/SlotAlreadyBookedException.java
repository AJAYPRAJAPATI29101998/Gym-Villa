package com.stackroute.bookingservice.exceptions;

public class SlotAlreadyBookedException extends Exception{
    public SlotAlreadyBookedException(String s){
        super(s);
    }
}
