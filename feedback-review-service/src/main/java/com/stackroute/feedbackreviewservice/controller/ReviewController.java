package com.stackroute.feedbackreviewservice.controller;


import com.stackroute.feedbackreviewservice.exception.ReviewAlreadyExistsException;
import com.stackroute.feedbackreviewservice.exception.ReviewNotFoundException;
import com.stackroute.feedbackreviewservice.model.Review;
import com.stackroute.feedbackreviewservice.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//import org.springframework.web.bind.annotation.*;


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

    public Review saveReview(@RequestBody Review review) throws ReviewAlreadyExistsException {

        return reviewService.saveReview(review);
    }

    @GetMapping("/getByBookingId/{id}")

    public Review getReviewById(@PathVariable Integer id) throws ReviewNotFoundException {
        return reviewService.getReviewByBookingId(id);
    }
}
