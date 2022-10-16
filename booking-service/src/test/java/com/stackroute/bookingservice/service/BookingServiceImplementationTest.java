package com.stackroute.bookingservice.service;

import com.stackroute.bookingservice.dto.*;
import com.stackroute.bookingservice.exceptions.DataNotPresentException;
import com.stackroute.bookingservice.exceptions.SameEntryException;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class BookingServiceImplementationTest {

    @Autowired
    private BookingServiceImplementation bookingService;
    @Autowired
    private GymOwnerServiceImplementation gymOwnerService;
    Booking booking = null;
    GymOwner gymOwner = null;
    Slot slot1 = null;
    Slot slot2 = null;
    GymSubscriptions gymSubscription1 = null;
    GymSubscriptions gymSubscription2 = null;
    List<GymSubscriptions> gymSubscriptions = null;
    List<Slot> slots = null;

    @BeforeAll
    void addingTestObject() throws SameEntryException {
        slot1 = new Slot(45, Status.AVAILABLE, "5-6P.M");
        slot2 = new Slot(46, Status.BOOKED, "9-10P.M");
        slots = new ArrayList<>();
        slots.add(slot1);
        slots.add(slot2);
        gymSubscription1 = new GymSubscriptions(798, "Basic", 3000.0);
        gymSubscription2 = new GymSubscriptions(799, "Advance", 4000.0);
        gymSubscriptions = new ArrayList<>();
        gymSubscriptions.add(gymSubscription1);
        gymSubscriptions.add(gymSubscription2);
        gymOwner = new GymOwner(199, "Test Gym", "Test",
                "test@gmail.com", slots, gymSubscriptions);
        this.gymOwnerService.addGymData(gymOwner);
        gymOwner = new GymOwner(199, "Test Gym", "Test",
                "test@gmail.com", slots, gymSubscriptions);
        booking = new Booking(756,"Test TestBooking","test@gmail.com",45,45,gymSubscription1,199);
    }



    @Test
    void addBookingStatus() {
        this.bookingService.addBookingStatus(booking);
        assertEquals(756,booking.getBookingId());
        assertEquals("Test TestBooking",booking.getUserName());
        assertEquals("test@gmail.com",booking.getUserEmail());
        assertEquals(45,booking.getUserId());
        assertEquals(45, booking.getSlotId());
        assertEquals(gymSubscription1, booking.getGymSubscriptions());
        assertEquals(199, booking.getGymOwnerId());

    }

    @Test
    void getBookingByid() {
        assertEquals("test@gmail.com",this.bookingService.getBookingByid(756).getUserEmail());
    }


    @Test
    void updateBooking() {
        this.bookingService.updateBooking(new Booking(756,"Test TestBooking2","test@gmail.com",45,45,gymSubscription1,199));
        assertEquals("Test TestBooking2",this.bookingService.getBookingByid(756).getUserName());
    }


    @AfterAll
    void deleteBookingByIdTest() throws DataNotPresentException {
      String value =  this.bookingService.deleteBookingById(756);
        this.gymOwnerService.deleteGymById(199);
        assertEquals("Delete Successful",value);

    }
}