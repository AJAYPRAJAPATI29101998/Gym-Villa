package com.stackroute.emailservice.config;


import com.stackroute.emailservice.pojo.Email;
import com.stackroute.emailservice.service.EmailServiceImpl;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import rabbitmq.domain.UserDTO;

@Component
public class Consumer {

    @Autowired
    private EmailServiceImpl emailService;

    @RabbitListener(queues = "booking_queue")
    public void getUserDtoFromRabbitMq(UserDTO userDTO)
    {
        System.out.println(userDTO.toString());
        Email email=new Email();
        email.setRecipientId(userDTO.getRecipientId());
        email.setSubject(userDTO.getSubject());
        email.setMessageBody("This is message body");
    }


}
