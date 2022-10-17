package com.stackroute.bookingservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "booking")
public class Booking {
    @MongoId
    private Integer bookingId;
    @NotBlank
    @Size(min = 4,max = 200,message = "Name size is less then 4")
    private String userName;
    @NotBlank(message = "Email should not be blank")
    private String userEmail;
    private Integer userId;
    private int slotId;
    private GymSubscription gymSubscriptions;
    private int gymOwnerId;
}
