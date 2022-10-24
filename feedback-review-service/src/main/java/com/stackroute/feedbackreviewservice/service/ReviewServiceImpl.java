package com.stackroute.feedbackreviewservice.service;

import com.stackroute.feedbackreviewservice.model.Review;
import com.stackroute.feedbackreviewservice.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ReviewServiceImpl implements ReviewService {

@Autowired
private ReviewRepository reviewRepo;
@Autowired
    public ReviewServiceImpl(ReviewRepository reviewRepo) {
        this.reviewRepo = reviewRepo;
    }

    @Override
    public Review saveReview(Review review) {
        return reviewRepo.save(review);
    }

    @Override
    public Review getReviewByBookingId(Integer bookingId) {
       return reviewRepo.findById(bookingId).get();
    }
}
