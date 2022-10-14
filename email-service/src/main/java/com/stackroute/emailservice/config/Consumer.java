package com.stackroute.emailservice.config;



import com.stackroute.emailservice.exception.MailNotFoundException;
import com.stackroute.emailservice.service.BookingMailService;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import rabbitmq.domain.UserDTO;



@Component
public class Consumer {

    @Autowired
    private BookingMailService bookingMailService;

    @RabbitListener(queues = "booking_queue")
    public void getUserDtoFromRabbitMq(UserDTO userDTO) throws MailNotFoundException {
        UserDTO userDTOConsumer=new UserDTO();
        userDTOConsumer.setBookingId(userDTO.getBookingId());
        userDTOConsumer.setUserEmail(userDTO.getUserEmail());
        userDTOConsumer.setGymOwnerEmail(userDTO.getGymOwnerEmail());
        userDTOConsumer.setGymId(userDTO.getGymId());
        userDTOConsumer.setUserName(userDTO.getUserName());
        userDTOConsumer.setBookingDate(userDTO.getBookingDate());
        userDTOConsumer.setSlotInfo(userDTO.getSlotInfo());
        userDTOConsumer.setSubscriptionPlan(userDTO.getSubscriptionPlan());

        this.bookingMailService.sendEmailToUser(userDTOConsumer);
        this.bookingMailService.sendEmailToGymOwner(userDTOConsumer);

    }


}
