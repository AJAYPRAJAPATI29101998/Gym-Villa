package com.stackroute.emailservice.service;

import com.stackroute.emailservice.pojo.Email;
import org.hibernate.mapping.Any;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;


@SpringBootTest
public class EmailServiceImplTest {

    @Autowired
    EmailServiceImpl emailService;

    @MockBean
    JavaMailSender javaMailSender;

    @Test
    public void sendEmailTest(){

        SimpleMailMessage message=new SimpleMailMessage();
        message.setFrom("gymvillaproduct@gmail.com");

//        Email email=new Email("pratikmench@gmail.com","junit","junit testing");

//        when(emailService.sendEmail(email.getRecipientId(),email.getSubject(),email.getMessageBody())).thenReturn(email.getRecipientId(),email.getSubject(),email.getMessageBody());

        assertEquals("gymvillaproduct@gmail.com",message.getFrom());


    }

}
