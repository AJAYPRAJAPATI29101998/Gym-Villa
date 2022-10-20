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
        return new Queue("email_queue");
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



    public static final String QUEUE_NAME = "feedback_queue";
    public static final String TOPIC_EXCHNAGE = "booking_feedback_information_slots";
    public static final String ROUTING_KEY = "booking_feedback_routingkey";


    @Bean
    public Queue queue1() {
        return new Queue(QUEUE_NAME);
    }

    @Bean
    public TopicExchange topicExchange1() {
        return new TopicExchange(TOPIC_EXCHNAGE);
    }

    @Bean
    public Binding binding1(Queue queue1, TopicExchange topicExchange1) {
        return BindingBuilder.bind(queue1).to(topicExchange1).with(ROUTING_KEY);
    }

    @Bean
    public MessageConverter messageConverter1() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public AmqpTemplate template1(ConnectionFactory connectionFactory) {
        RabbitTemplate template1 = new RabbitTemplate(connectionFactory);
        template1.setMessageConverter(messageConverter1());
        return template1;
    }


}
