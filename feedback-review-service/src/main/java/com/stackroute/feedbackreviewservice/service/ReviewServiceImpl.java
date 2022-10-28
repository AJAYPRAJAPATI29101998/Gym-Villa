package com.stackroute.feedbackreviewservice.service;

import com.stackroute.feedbackreviewservice.exception.GymIdNotFoundException;
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
            throw new ReviewNotFoundException("review not present");
        }

       return review;
    }

    @Override
    public List<Review> getDetailsByGymId(Integer gymId) throws GymIdNotFoundException{
        List<Review> GymDetailByGymId=reviewRepo.getGymByGymId(gymId);
        if(GymDetailByGymId.isEmpty()){
            throw new GymIdNotFoundException("gym id not present");
        }
        return GymDetailByGymId;
    }


    }

