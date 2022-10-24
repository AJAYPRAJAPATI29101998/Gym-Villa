package com.stackroute.paymentservice.service;

import com.paypal.api.payments.Payment;
import com.paypal.base.rest.PayPalRESTException;
import com.stackroute.paymentservice.entity.Order;

public interface PaypalService {
    Payment createPayment(Order order, String cancelUrl, String successUrl)throws PayPalRESTException;
    Payment executePayment(String paymentId,String payerId) throws PayPalRESTException;

}