package com.stackroute.emailservice.service;

import com.stackroute.emailservice.pojo.Email;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailserviceI{

    final
    JavaMailSender javaMailSender;

    public EmailServiceImpl(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    @Override
    public String sendEmail(String recipientId,String subject,String messageBody) {

        SimpleMailMessage message=new SimpleMailMessage();

        message.setFrom("gymvillaproduct@gmail.com");
        message.setTo(recipientId);
        message.setSubject(subject);
        message.setText(messageBody);

        javaMailSender.send(message);

        return "Mail sent successfully";
    }
}
