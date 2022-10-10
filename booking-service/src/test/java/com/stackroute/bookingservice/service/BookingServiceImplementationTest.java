package com.stackroute.bookingservice.service;

import com.stackroute.bookingservice.dao.BookingRepository;
import com.stackroute.bookingservice.dto.Booking;
import com.stackroute.bookingservice.dto.Status;
import org.junit.jupiter.api.Test;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class BookingServiceImplementationTest {

    @Autowired
    BookingServiceImplementation bookingServiceImplementation;
    @Autowired
    BookingRepository bookingRepository;

    @MockBean
    @Autowired
    BookingRepository bookingRepositoryMock;

//    @Test
//    void addBookingStatus(){
//        Booking booking1 = new Booking(9,"Test","test@gmail.com",62,4, Status.AVAILABLE);
//       bookingServiceImplementation.addBookingStatus(booking1);
//        Boolean trueIfPresent = bookingRepository.existsById(9);
//        //Booking b = this.bookingRepository.findById(9).get();
//        assertTrue(trueIfPresent);
//    }

    @Test
    void getBookingByid(){
        when(bookingRepositoryMock.findById(8))
                .thenReturn(Optional.of(new Booking(8, "Test2", "test2@gmail.com", 62, 4, Status.BOOKED)));
        assertEquals("Test2" , bookingServiceImplementation.getBookingByid(8).getUserName());
    }


//    @Test
//    void deleteBookingById() {
//        String val ="Delete Successful";
//        OngoingStubbing<T> tOngoingStubbing = when(bookingRepository.deleteById(8)).thenReturn(val);
//
//    }
}