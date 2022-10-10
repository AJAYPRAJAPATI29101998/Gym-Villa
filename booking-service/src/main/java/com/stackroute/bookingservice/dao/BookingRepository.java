package com.stackroute.bookingservice.dao;

import com.stackroute.bookingservice.dto.Booking;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookingRepository extends MongoRepository<Booking , Integer> {

}
