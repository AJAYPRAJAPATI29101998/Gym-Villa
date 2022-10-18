package com.stackroute.bookingservice.service;

import com.stackroute.bookingservice.exceptions.DataNotPresentException;
import com.stackroute.bookingservice.model.Booking;

import java.sql.SQLException;
import java.util.List;

public interface BookingService {
    Booking addBookingStatus(Booking booking);

    Booking getBookingByid(int id) throws DataNotPresentException;

    Boolean deleteBookingById(int id);

    Booking updateBooking(Booking booking);

    List<Booking> getAllBookings() throws SQLException;

    int getSequenceNumber(String sequenceName);

}
