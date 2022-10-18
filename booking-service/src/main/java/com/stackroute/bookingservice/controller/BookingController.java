package com.stackroute.bookingservice.controller;

import com.stackroute.bookingservice.exceptions.DataNotPresentException;
import com.stackroute.bookingservice.exceptions.SameEntryException;
import com.stackroute.bookingservice.exceptions.SlotAlreadyBookedException;
import com.stackroute.bookingservice.model.Booking;
import com.stackroute.bookingservice.model.GymOwner;
import com.stackroute.bookingservice.rqmproducer.FeedBackServiceQueue;
import com.stackroute.bookingservice.service.BookingServiceImplementation;
import com.stackroute.bookingservice.service.GymOwnerServiceImplementation;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
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
    public ResponseEntity<?> addBooking(@Valid @RequestBody Booking newBooking) throws DataNotPresentException, SlotAlreadyBookedException {
        try {
            Boolean check = this.gymService.checkBookedSlot(newBooking.getSlotId(), newBooking.getGymId());
            if (check) {
                newBooking.setCreatedAt(LocalDateTime.now());
                newBooking.setBookingId(bookingService.getSequenceNumber(Booking.SEQUENCE_NAME));
                Booking booking = this.bookingService.addBookingStatus(newBooking);
                this.gymService.updateSlotToBooked(newBooking.getGymId(), newBooking.getSlotId());
                rabbitTemplate.convertAndSend("booking_information_slots", "booking_routingkey", booking);
                rabbitTemplate.convertAndSend(FeedBackServiceQueue.TOPIC_EXCHNAGE,FeedBackServiceQueue.ROUTING_KEY,booking);
                return new ResponseEntity<>(this.bookingService.getBookingByid(newBooking.getBookingId()), HttpStatus.OK);
            }
            return new ResponseEntity<>("Slot already booked", HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            throw e;
        }
    }

    @GetMapping("/slots/{id}")
    public GymOwner getAvailableSlots(@PathVariable int id) throws DataNotPresentException {
        return this.gymService.getSlotsByGymId(id);
    }


    @DeleteMapping("booking/{id}")
    public ResponseEntity<?> deleteBooking(@PathVariable int id) throws DataNotPresentException {
        Booking booking = this.bookingService.getBookingByid(id);

        Boolean check = this.bookingService.deleteBookingById(id);
        if (check) {

            this.gymService.updateSlotToAvailable(booking.getGymId(), booking.getSlotId());
            return new ResponseEntity<>("Booking Deleted", HttpStatus.OK);
        }

        return new ResponseEntity<>("Can't able to delete Booking", HttpStatus.BAD_REQUEST);
    }
}
