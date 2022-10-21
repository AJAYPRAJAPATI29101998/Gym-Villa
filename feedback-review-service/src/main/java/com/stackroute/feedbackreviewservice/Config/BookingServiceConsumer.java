package com.stackroute.feedbackreviewservice.Config;


import com.stackroute.feedbackreviewservice.model.Review;
import com.stackroute.feedbackreviewservice.repository.ReviewRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookingServiceConsumer {

    @Autowired
    private ReviewRepository feedBackRepo;

    @RabbitListener(queues = "feedback_queue")
    public void  getUserDtoFromRabbitMq(Review review){

        System.out.println(review);
        Review reviewConsumer= new Review();
        reviewConsumer.setBookingId(review.getBookingId());
        reviewConsumer.setUserName(review.getUserName());
        reviewConsumer.setUserEmail(review.getUserEmail());
        reviewConsumer.setGymOwnerEmail(review.getGymOwnerEmail());
        reviewConsumer.setSlotId(review.getSlotId());
        reviewConsumer.setGymSubscription(review.getGymSubscription());
        reviewConsumer.setGymId(review.getGymId());
        reviewConsumer.setReviews("null");
        reviewConsumer.setRating("0");
        System.out.println(reviewConsumer.toString());
        feedBackRepo.save(reviewConsumer);
    }

}
