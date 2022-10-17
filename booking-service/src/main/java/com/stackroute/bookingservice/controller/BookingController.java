package com.stackroute.bookingservice.controller;

import com.stackroute.bookingservice.model.Booking;
import com.stackroute.bookingservice.exceptions.DataNotPresentException;
import com.stackroute.bookingservice.model.GymOwner;
import com.stackroute.bookingservice.service.BookingServiceImplementation;
import com.stackroute.bookingservice.service.GymOwnerServiceImplementation;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class BookingController {

    @Autowired
    private GymOwnerServiceImplementation gymService;
    @Autowired
    private BookingServiceImplementation bookingService;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @GetMapping("/gym")
    public List<GymOwner> getAllGymData() throws DataNotPresentException {
        return this.gymService.listAllGym();
    }

    @PostMapping("/booking")
    public Booking addBooking(@Valid @RequestBody Booking newBooking) throws DataNotPresentException {
        try {
            Booking booking = this.bookingService.addBookingStatus(newBooking);
            this.gymService.updateSlote(newBooking.getGymOwnerId(), newBooking.getSlotId());
            rabbitTemplate.convertAndSend("booking_information_slots","booking_routingkey",booking);
            return this.bookingService.getBookingByid(newBooking.getBookingId());
        } catch (Exception e) {
            throw e;
        }
    }

    @GetMapping("/slots/{id}")
    public GymOwner getAvailableSlots(@PathVariable int id) throws DataNotPresentException {
        return this.gymService.getSlotsByGymId(id);
    }


//    @DeleteMapping("booking/{id}")
//    public ResponseEntity<?> deleteBooking(@PathVariable int id){
//
//    }
}
