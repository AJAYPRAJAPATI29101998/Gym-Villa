package com.stackroute.feedbackreviewservice.service;

import com.stackroute.feedbackreviewservice.exception.ReviewAlreadyExistsException;
import com.stackroute.feedbackreviewservice.exception.ReviewNotFoundException;
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
    public ReviewServiceImpl(ReviewRepository reviewRep0) {
        this.reviewRepo = reviewRepo;
    }

    @Override
    public Review saveReview(Review review) throws ReviewAlreadyExistsException {
        Review existingReview = reviewRepo.findById(review.getBookingId()).orElse(null);
        if (existingReview != null) {
            if (existingReview.getReviews().equals("null") || existingReview.getRating().equals("0")) {
                System.out.println(existingReview);
                System.out.println(review);
                return reviewRepo.save(review);
            }
            throw new ReviewAlreadyExistsException("review already exists");
        }
        return null;
        //  return reviewRepo.save(review);
    }

    Review reviewById = null;

    @Override

    public Review getReviewByBookingId(Integer bookingId) throws ReviewNotFoundException {
        Review review = reviewRepo.findById(bookingId).orElse(null);
        if(review==null){
            throw new ReviewNotFoundException("review not");
        }
//        if (review.getReviews() != null || review.getRating() != null) {
//            return review;
//        }
        //        reviewById = reviewRepo.findById(bookingId).orElse(null);
//      // Review reviewById = reviewRepo.findByBookingid(bookingId);
//        if (reviewById == null) {
//            throw new ReviewNotFoundException("review not exists with this id");
//        //  return reviewRepo.findById(bookingId).get();
//    } else
//
//    {
//        return  reviewRepo.findById(bookingId).orElse(null);
        //   }


//    @Override
//    public Review findByBookingId(Integer id) {
//        return reviewRepo.findById()id);
       return review;
    }
}
