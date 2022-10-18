package com.stackroute.feedbackreviewservice.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GymSubscription {

    private Subscription subscriptionType;
    private Double SubscriptionCost;
}
