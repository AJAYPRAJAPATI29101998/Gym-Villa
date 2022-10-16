package com.stackroute.gymownerservice.Config;

import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.stackroute.gymownerservice.model.GymOwner;

@Component
public class Producer {
    private String routingName = "gymOwnerRouting";
    private RabbitTemplate rabbitTemplate;
    private DirectExchange directExchange;
    @Autowired
    public Producer(RabbitTemplate rabbitTemplate, DirectExchange directExchange)
    {
        super();
        this.rabbitTemplate = rabbitTemplate;
        this.directExchange = directExchange;
    }

    public String sendMessageToRabbitMq(GymOwner gymOwner)
    {
        rabbitTemplate.convertAndSend(directExchange.getName(), routingName, gymOwner);
        return "Message sent successfully";
    }
}
