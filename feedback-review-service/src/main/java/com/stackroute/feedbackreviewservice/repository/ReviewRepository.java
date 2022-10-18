package com.stackroute.feedbackreviewservice.repository;

import com.stackroute.feedbackreviewservice.model.Review;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ReviewRepository extends MongoRepository<Review,Integer> {
}
