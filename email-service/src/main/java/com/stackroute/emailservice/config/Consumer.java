package com.stackroute.emailservice.config;



import com.stackroute.emailservice.exception.BookingIdNotFoundException;
import com.stackroute.emailservice.exception.MailNotFoundException;
import com.stackroute.emailservice.pojo.GymSubscriptions;
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

    @RabbitListener(queues = "booking_queue")
    public void getUserDtoFromRabbitMq(UserDTO userDTO) throws MailNotFoundException, BookingIdNotFoundException, MailException {
        System.out.println(userDTO);
        UserDTO userDTOConsumer=new UserDTO();
        userDTOConsumer.setBookingId(Integer.valueOf(userDTO.getBookingId()));
        userDTOConsumer.setUserName(userDTO.getUserName());
        userDTOConsumer.setUserEmail(userDTO.getUserEmail());
        userDTOConsumer.setDateTime(userDTO.getDateTime());
        userDTOConsumer.setGymOwnerEmail(userDTO.getGymOwnerEmail());
        userDTOConsumer.setSlotId(userDTO.getSlotId());
        userDTOConsumer.setSubscriptionPlan(new GymSubscriptions(userDTO.getSubscriptionPlan().getSubscriptionId(),userDTO.getSubscriptionPlan().getSubscriptionName(), userDTO.getSubscriptionPlan().getPrice()));
        userDTOConsumer.setGymOwnerId((Integer.valueOf(userDTO.getGymOwnerId())));

        this.bookingMailService.sendEmailToUser(userDTOConsumer);
        this.bookingMailService.sendEmailToGymOwner(userDTOConsumer);

    }


}
