
//package com.stackroute.emailservice.config;
//
//
//import org.springframework.amqp.core.Binding;
//import org.springframework.amqp.core.BindingBuilder;
//import org.springframework.amqp.core.DirectExchange;
//import org.springframework.amqp.core.Queue;
//import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class MessageConfiguration {
//
////    private String exchangeName="booking_information_slots";
////    private String registerQueue="booking_queue";
////
////    @Bean
////    public Jackson2JsonMessageConverter jsonMessageConverter(){return  new Jackson2JsonMessageConverter();}
////
////    @Bean
////    public DirectExchange directExchange(){return new DirectExchange(exchangeName);}
////
////    @Bean
////    public Queue registerQueue(){return new Queue(registerQueue,false);}
////
////    @Bean
////    Binding bindingUser(Queue regisQueue, DirectExchange exchange){
////        return BindingBuilder.bind(registerQueue()).to(exchange).with("booking_routingkey");
////    }
//
//}

package com.stackroute.emailservice.config;


import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MessageConfiguration {
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

}

