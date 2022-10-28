package com.stackroute.feedbackreviewservice.repository;

import com.stackroute.feedbackreviewservice.model.Review;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ReviewRepository extends MongoRepository<Review,Integer> {

    @Query("{gymId :?0}")                                                  //SQL Equivalent : SELECT * FROM BOOK WHERE ID=?
    List<Review> getGymByGymId(Integer gymId);
}
