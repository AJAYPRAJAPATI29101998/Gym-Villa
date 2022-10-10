package com.stackroute.bookingservice.controller;

import com.stackroute.bookingservice.dto.Booking;
import com.stackroute.bookingservice.service.BookingServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
public class BookingController {

    @Autowired
    private BookingServiceImplementation bookingServiceImplementation;

    @GetMapping("/allbooking")
    public List<Booking> allBookings() throws SQLException {
        return this.bookingServiceImplementation.getAllBookings();
    }

    @PostMapping("/booking")
    public Booking addBooking(@RequestBody Booking booking){
        return this.bookingServiceImplementation.addBookingStatus(booking);
    }

    @GetMapping("/{id}")
    public Booking getBooking(@PathVariable int id){
        return this.bookingServiceImplementation.getBookingByid(id);
    }
    @DeleteMapping("/{id}")
    public String deleteBooking(@PathVariable int id){
        return this.bookingServiceImplementation.deleteBookingById(id);
    }
    @PutMapping("/booking-change")
    public Booking updateBooking(@RequestBody Booking booking){
    return this.bookingServiceImplementation.updateBooking(booking);
    }

}
