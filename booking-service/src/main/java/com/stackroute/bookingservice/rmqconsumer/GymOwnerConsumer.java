package com.stackroute.bookingservice.rmqconsumer;

import com.stackroute.bookingservice.exceptions.SameEntryException;
import com.stackroute.bookingservice.model.GymOwner;
import com.stackroute.bookingservice.service.GymOwnerService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GymOwnerConsumer {

    @Autowired
    GymOwnerService gymOwnerService;

    @RabbitListener(queues = "owner_queue")
    public void consumer(GymOwner gymOwner) throws SameEntryException {

        System.out.println(gymOwner);

        gymOwnerService.addGymData(gymOwner);

    }

}
