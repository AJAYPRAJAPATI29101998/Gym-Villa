package com.stackroute.bookingservice.rqmproducer;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BookingQueue {

    @Bean
    public Queue queue(){
        return new Queue("booking_queue");
    }
    @Bean
    public TopicExchange topicExchange(){
        return new TopicExchange("booking_information_slots");
    }

    @Bean
    public Binding binding(Queue queue,TopicExchange topicExchange){
        return BindingBuilder.bind(queue).to(topicExchange).with("booking_routingkey");
    }

    @Bean
    public MessageConverter messageConverter(){
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public AmqpTemplate template(ConnectionFactory connectionFactory){
        RabbitTemplate template = new RabbitTemplate(connectionFactory);
        template.setMessageConverter(messageConverter());
        return template;
    }


}
