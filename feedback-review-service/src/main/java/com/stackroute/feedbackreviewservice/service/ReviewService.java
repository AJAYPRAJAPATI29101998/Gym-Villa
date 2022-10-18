package com.stackroute.feedbackreviewservice.service;


import com.stackroute.feedbackreviewservice.model.Review;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ReviewService {

   Review saveReview(Review review) ;

   List<Review> getReviewByBookingId (Integer bookingId);




}
