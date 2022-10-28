//package com.stackroute.bookingservice.controller;
//
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.stackroute.bookingservice.exceptions.DataNotPresentException;
//import com.stackroute.bookingservice.model.Booking;
//import com.stackroute.bookingservice.model.GymSubscription;
//import com.stackroute.bookingservice.model.Subscription;
//import com.stackroute.bookingservice.service.BookingServiceImplementation;
//import com.stackroute.bookingservice.service.GymOwnerServiceImplementation;
//import org.junit.jupiter.api.Test;
//import org.mockito.ArgumentMatcher;
//import org.mockito.ArgumentMatchers;
//import org.mockito.Mockito;
//import org.reactivestreams.Publisher;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.mock.web.MockHttpServletResponse;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.MvcResult;
//import org.springframework.test.web.servlet.ResultActions;
//import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//
//import java.time.LocalDateTime;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static reactor.core.publisher.Mono.when;
//
//@WebMvcTest(value = BookingController.class)
//class BookingControllerTest {
//
//    @MockBean
//    public BookingServiceImplementation bookingService;
//    @MockBean
//    private GymOwnerServiceImplementation gymOwnerService;
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    Booking booking = new Booking(1234,"Test","test@gmail.com", LocalDateTime.now(),"testgymowner@gmail.com",9
//            , new GymSubscription(Subscription.annually,980.0),234);
//
//    @Test
//    void getAllGymData() {
//    }
//
//    @Test
//    void addBookingTest() throws Exception{
//
//        Mockito.when(bookingService.addBookingStatus(ArgumentMatchers.any())).thenReturn(booking);
//        ObjectMapper objectMapper = new ObjectMapper();
//        String jsonBooking = objectMapper.writeValueAsString(booking);
//        MockHttpServletRequestBuilder requestBuilder =
//                MockMvcRequestBuilders.post("/api/v1/Booking-service/booking")
//                        .contentType(MediaType.APPLICATION_JSON).content(jsonBooking);
//       ResultActions perform = mockMvc.perform(requestBuilder);
//        MvcResult mvcResult = perform.andReturn();
//        MockHttpServletResponse response = mvcResult.getResponse();
//        int status = response.getStatus();
//        assertEquals(201,status);
//
//    }
//
//    @Test
//    void getAvailableSlots() {
//    }
//
//    @Test
//    void deleteBooking() {
//    }
//}