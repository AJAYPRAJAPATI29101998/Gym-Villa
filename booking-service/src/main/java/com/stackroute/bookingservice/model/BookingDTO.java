package com.stackroute.bookingservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookingDTO {


    private Integer bookingId;
    private String userName;
    private String userEmail;
    private String createdAt;
    private String gymOwnerEmail;
    private int slotId;
    private GymSubscription gymSubscription;
    private int gymId;
}
