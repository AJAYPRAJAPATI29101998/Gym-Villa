package com.stackroute.paymentservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor


public class Order {
    private double price;
    private String currency;
    private String method;

    private String intent;
    private String description;

    public Order(){
        super();
    }



}