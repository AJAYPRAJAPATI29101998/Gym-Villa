//package com.stackroute.bookingservice.service;
//
//import com.stackroute.bookingservice.exceptions.DataNotPresentException;
//import com.stackroute.bookingservice.exceptions.SameEntryException;
//import com.stackroute.bookingservice.model.*;
//import org.junit.jupiter.api.*;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.time.LocalDateTime;
//import java.util.ArrayList;
//import java.util.List;
//
//import static com.stackroute.bookingservice.model.SlotTime.Evening;
//import static com.stackroute.bookingservice.model.SlotTime.Morning;
//import static org.junit.jupiter.api.Assertions.*;
//
//@SpringBootTest
//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
//class BookingServiceImplementationTest {
//
//    @Autowired
//    private BookingServiceImplementation bookingService;
//    @Autowired
//    private GymOwnerServiceImplementation gymOwnerService;
//    Booking booking = null;
//    GymOwner gymOwner = null;
//    GymSlot slot1 = null;
//    GymSlot slot2 = null;
//    GymSubscription gymSubscription1 = null;
//    GymSubscription gymSubscription2 = null;
//    List<GymSubscription> gymSubscriptions = null;
//    List<GymSlot> slots = null;
//
//    @BeforeAll
//    void addingTestObject() throws SameEntryException {
//
//    }
//
//
//
//    @Test
//    void addBookingStatus() {
//
//    }
//
//    @Test
//    void getBookingByid() {
//    }
//
//
//    @Test
//    void updateBooking() {
//       }
//
//
//    @AfterAll
//    void deleteBookingByIdTest() throws DataNotPresentException {
//
//    }
//}
//
//
////package com.stackroute.bookingservice.service;
////
////import com.stackroute.bookingservice.dto.*;
////import com.stackroute.bookingservice.exceptions.DataNotPresentException;
////import com.stackroute.bookingservice.exceptions.SameEntryException;
////import com.stackroute.bookingservice.model.*;
////import org.junit.jupiter.api.*;
////import org.springframework.beans.factory.annotation.Autowired;
////import org.springframework.boot.test.context.SpringBootTest;
////
////import java.time.LocalDateTime;
////import java.util.ArrayList;
////import java.util.List;
////
////import static com.stackroute.bookingservice.model.SlotTime.Evening;
////import static com.stackroute.bookingservice.model.SlotTime.Morning;
////import static org.junit.jupiter.api.Assertions.*;
////
////@SpringBootTest
////@TestInstance(TestInstance.Lifecycle.PER_CLASS)
////class BookingServiceImplementationTest {
////
////    @Autowired
////    private BookingServiceImplementation bookingService;
////    @Autowired
////    private GymOwnerServiceImplementation gymOwnerService;
////    Booking booking = null;
////    GymOwner gymOwner = null;
////    GymSlot slot1 = null;
////    GymSlot slot2 = null;
////    GymSubscription gymSubscription1 = null;
////    GymSubscription gymSubscription2 = null;
////    List<GymSubscription> gymSubscriptions = null;
////    List<GymSlot> slots = null;
////
////    @BeforeAll
////    void addingTestObject() throws SameEntryException {
////        slot1 = new GymSlot( 45, SlotTime.Morning,SlotStatus.AVAILABLE);
////        slot2 = new GymSlot( 46, SlotTime.Evening,SlotStatus.BOOKED);
////        slots = new ArrayList<>();
////        slots.add(slot1);
////        slots.add(slot2);
////        gymSubscription1 = new GymSubscription( Subscription.annually, 3000.0);
////        gymSubscription2 = new GymSubscription( Subscription.monthly, 4000.0);
////        gymSubscriptions = new ArrayList<>();
////        gymSubscriptions.add(gymSubscription1);
////        gymSubscriptions.add(gymSubscription2);
////        gymOwner = new GymOwner(189,"Test1","Test","test@gm.com","Indore","67 Ashok Test",482001
////        , 83922828,slots,gymSubscriptions);
////        this.gymOwnerService.addGymData(gymOwner);
////        gymOwner = new GymOwner(190,"Test2","testName","test2@gm.com","Jabalpur","test address",83920
////        ,89201830,slots,gymSubscriptions);
////        booking = new Booking(756,"Test User","testuser@gl.com", LocalDateTime.now(),);
////    }
////
////
////
////    @Test
////    void addBookingStatus() {
////        this.bookingService.addBookingStatus(booking);
////        assertEquals(756,booking.getBookingId());
////        assertEquals("Test TestBooking",booking.getUserName());
////        assertEquals("test@gmail.com",booking.getUserEmail());
////        assertEquals(45,booking.getUserId());
////        assertEquals(45, booking.getSlotId());
////        assertEquals(gymSubscription1, booking.getGymSubscriptions());
////        assertEquals(199, booking.getGymOwnerId());
////
////    }
////
////    @Test
////    void getBookingByid() {
////        assertEquals("test@gmail.com",this.bookingService.getBookingByid(756).getUserEmail());
////    }
////
////
////    @Test
////    void updateBooking() {
////        this.bookingService.updateBooking(new Booking(756,"Test TestBooking2","test@gmail.com",45,45,gymSubscription1,199));
////        assertEquals("Test TestBooking2",this.bookingService.getBookingByid(756).getUserName());
////    }
////
////
////    @AfterAll
////    void deleteBookingByIdTest() throws DataNotPresentException {
////      String value =  this.bookingService.deleteBookingById(756);
////        this.gymOwnerService.deleteGymById(199);
////        assertEquals("Delete Successful",value);
////
////    }
////}