package com.stackroute.feedbackreviewservice.controller;


import com.stackroute.feedbackreviewservice.model.Review;
import com.stackroute.feedbackreviewservice.service.ReviewService;
import com.stackroute.feedbackreviewservice.service.ReviewServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
//import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/Feedback-review-service")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;
    @Autowired
    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @PostMapping("/addReview")

    public Review saveReview(@RequestBody Review review){

        return reviewService.saveReview(review);
    }

    @GetMapping("/getByBookingId/{BookingID}")

    public List<Review> getReviewById(@PathVariable Integer id){
        return reviewService.getReviewByBookingId(id);
    }
}
