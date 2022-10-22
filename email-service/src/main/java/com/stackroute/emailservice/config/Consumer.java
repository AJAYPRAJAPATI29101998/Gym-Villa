package com.stackroute.emailservice.config;



import com.stackroute.emailservice.exception.BookingIdNotFoundException;
import com.stackroute.emailservice.exception.MailNotFoundException;
import com.stackroute.emailservice.pojo.GymSubscription;
import com.stackroute.emailservice.service.BookingMailService;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.stereotype.Component;
import rabbitmq.domain.UserDTO;



@Component
public class Consumer {

    @Autowired
    private BookingMailService bookingMailService;

    @RabbitListener(queues = "email_queue")
    public void getUserDtoFromRabbitMq(UserDTO userDTO) throws MailNotFoundException, BookingIdNotFoundException, MailException {
        System.out.println(userDTO);

        UserDTO userDTOConsumer=new UserDTO();
        userDTOConsumer.setBookingId(userDTO.getBookingId());
        userDTOConsumer.setUserName(userDTO.getUserName());
        userDTOConsumer.setUserEmail(userDTO.getUserEmail());
        userDTOConsumer.setCreatedAt(userDTO.getCreatedAt());
        userDTOConsumer.setGymOwnerEmail(userDTO.getGymOwnerEmail());
        userDTOConsumer.setSlotId(userDTO.getSlotId());
        userDTOConsumer.setGymSubscription(new GymSubscription(userDTO.getGymSubscription().getSubscriptionType(), userDTO.getGymSubscription().getSubscriptionCost()));
        userDTOConsumer.setGymId(userDTO.getGymId());


        this.bookingMailService.sendEmailToUser(userDTOConsumer);
        this.bookingMailService.sendEmailToGymOwner(userDTOConsumer);

    }


}
