package com.stackroute.bookingservice.dao;

import com.stackroute.bookingservice.model.GymOwner;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GymOwnerRepository extends MongoRepository<GymOwner,Integer> {


}
