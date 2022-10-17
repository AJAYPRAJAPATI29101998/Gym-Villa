package com.stackroute.bookingservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GymSubscription {
    @Id
    private Subscription subscriptionType;
    private Double SubscriptionCost;
}
