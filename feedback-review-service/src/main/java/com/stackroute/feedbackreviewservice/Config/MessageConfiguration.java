package com.stackroute.feedbackreviewservice.Config;


import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MessageConfiguration {


    private String exchangeName="feedback_queue";
    private String registerQueue="booking_feedback_information_slots";

    @Bean
    public Jackson2JsonMessageConverter jsonMessageConverter(){return  new Jackson2JsonMessageConverter();}

    @Bean
    public DirectExchange directExchange(){return new DirectExchange(exchangeName);}

    @Bean
    public Queue registerQueue(){return new Queue(registerQueue,false);}

    @Bean
    Binding bindingUser(Queue regisQueue, DirectExchange exchange){
        return BindingBuilder.bind(registerQueue()).to(exchange).with("booking_feedback_routingkey\"");
    }

}
