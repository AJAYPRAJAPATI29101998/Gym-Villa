package com.stackroute.feedbackreviewservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import javax.validation.constraints.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection="review")


public class Review {
    @MongoId
    private Integer bookingId;
    @NotBlank
    @Size(min = 4,max = 200,message = "Name size is less then 4")
    private String userName;
     @NotBlank(message = "Email should not be blank")
    @Email
    private String userEmail;
     @Email(message = "please enter valid email id")
    private String gymOwnerEmail;
     @NotNull(message="slotId should not be empty")
    private int slotId;
    private GymSubscription gymSubscription;
    @NotNull(message="gymOwnerId should not be empty")
    private int gymOwnerId;

    private String reviews;
    @Min(value=0,message = "rating valid only from 0 to 10")
    @Max(value=10,message = "rating valid only from 0 to 10")
    private String rating;
}
