package com.stackroute.feedbackreviewservice.service;


import com.stackroute.feedbackreviewservice.exception.ReviewAlreadyExistsException;
import com.stackroute.feedbackreviewservice.exception.ReviewNotFoundException;
import com.stackroute.feedbackreviewservice.model.Review;

import java.util.List;


public interface ReviewService {

   Review saveReview(Review review) throws ReviewAlreadyExistsException;

   Review getReviewByBookingId (Integer bookingId) throws ReviewNotFoundException;


 // Review findByBookingId(Integer id);

}
