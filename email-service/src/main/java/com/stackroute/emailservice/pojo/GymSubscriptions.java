package com.stackroute.emailservice.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class GymSubscriptions {
    private int subscriptionId;
    private String subscriptionName;
    private Double price;

    public GymSubscriptions(int subscriptionId,String subscriptionName,Double price){
        this.subscriptionId=subscriptionId;
        this.subscriptionName=subscriptionName;
        this.price=price;
    }
}
