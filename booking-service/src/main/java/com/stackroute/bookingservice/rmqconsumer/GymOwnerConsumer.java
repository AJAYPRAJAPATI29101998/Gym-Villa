package com.stackroute.bookingservice.rmqconsumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class GymOwnerConsumer {

    @RabbitListener(queues = "owner_queue")
    public <T> void consumer(T obj){
        System.out.println(obj);
    }

}
