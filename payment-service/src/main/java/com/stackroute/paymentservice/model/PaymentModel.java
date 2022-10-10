package com.stackroute.paymentservice.model;

import jdk.jfr.DataAmount;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class PaymentModel {

    private double price;
    private String currency;
    private String method;
    private String intent;
    private String description;
}
