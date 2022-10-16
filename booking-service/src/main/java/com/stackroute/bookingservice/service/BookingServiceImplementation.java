package com.stackroute.bookingservice.service;

import com.stackroute.bookingservice.dao.BookingRepository;
import com.stackroute.bookingservice.dto.Booking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class BookingServiceImplementation implements BookingService {
    @Autowired
    private BookingRepository bookingRepository;

    @Override
    public Booking addBookingStatus(Booking booking) {
        return this.bookingRepository.save(booking);
    }

    @Override
    public Booking getBookingByid(int id) {
        return this.bookingRepository.findById(id).get();
    }

    @Override
    public String deleteBookingById(int id) {
        try {
            this.bookingRepository.deleteById(id);
            return "Delete Successful";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @Override
    public Booking updateBooking(Booking booking) {
        try {
            return this.bookingRepository.save(booking);
        } catch (Exception e) {
            System.err.println(e);
        }
        return null;
    }

    @Override
    public List<Booking> getAllBookings() throws SQLException {


        List<Booking> result = this.bookingRepository.findAll();
        return result;
    }
}
