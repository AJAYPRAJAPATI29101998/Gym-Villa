package com.stackroute.bookingservice.controller;

import com.stackroute.bookingservice.dto.Booking;
import com.stackroute.bookingservice.dto.GymOwner;
import com.stackroute.bookingservice.exceptions.DataNotPresentException;
import com.stackroute.bookingservice.service.BookingServiceImplementation;
import com.stackroute.bookingservice.service.GymOwnerServiceImplementation;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
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


//    @Autowired
//    private BookingServiceImplementation bookingServiceImplementation;
//    @Autowired
//    private UserServiceImplementation userService;
//
//    @Autowired
//    private RabbitTemplate template;
//
//    @GetMapping("/allbooking")
//    public List<Booking> allBookings() throws SQLException {
//        return this.bookingServiceImplementation.getAllBookings();
//    }
//    @PostMapping("/allbookings/{email}/{bid}")
//    public ResponseEntity<String> bookSlot(@RequestParam String email,@RequestParam int bid){
//        Status checkBookingStatus = this.bookingServiceImplementation.getBookingByid(bid).getBookingStatus();
//        if(checkBookingStatus.equals(AVAILABLE)){
//            User user=   this.userService.saveBookingStatus(new User(bid,email));
//           template.convertAndSend("booking_information_slots","booking_routingkey",user);
//           return ResponseEntity.of(Optional.of("Booking done"));
//        }
//        return ResponseEntity.of(Optional.of( "Not available"));
//    }
//
//    @PostMapping("/booking")
//    public Booking addBooking(@RequestBody Booking booking){
//        return this.bookingServiceImplementation.addBookingStatus(booking);
//    }
//
//    @GetMapping("/{id}")
//    public Booking getBooking(@PathVariable int id){
//        return this.bookingServiceImplementation.getBookingByid(id);
//    }
//    @DeleteMapping("/{id}")
//    public String deleteBooking(@PathVariable int id){
//        return this.bookingServiceImplementation.deleteBookingById(id);
//    }
//    @PutMapping("/booking-change")
//    public Booking updateBooking(@RequestBody Booking booking){
//    return this.bookingServiceImplementation.updateBooking(booking);
//    }

}
