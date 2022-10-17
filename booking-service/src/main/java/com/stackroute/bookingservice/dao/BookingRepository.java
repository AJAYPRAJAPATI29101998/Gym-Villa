package com.stackroute.bookingservice.dao;

import com.stackroute.bookingservice.model.Booking;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookingRepository extends MongoRepository<Booking , Integer> {

}
