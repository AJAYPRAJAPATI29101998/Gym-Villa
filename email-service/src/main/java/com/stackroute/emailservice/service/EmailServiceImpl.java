package com.stackroute.emailservice.service;

import com.stackroute.emailservice.exception.MailNotFoundException;
import com.stackroute.emailservice.pojo.Email;
import org.springframework.mail.MailException;
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
    public String sendSimpleMail(Email details) throws MailException {
        {
            try {
                SimpleMailMessage message=new SimpleMailMessage();

                message.setFrom("gymvillaproduct@gmail.com");
                message.setTo(details.getRecipientId());
                message.setSubject(details.getSubject());
                message.setText(details.getMessageBody());

                javaMailSender.send(message);
                System.out.println("Mail sent");
                return "Mail sent successfully";

            }catch (Exception exception){
                return "Email Id is not correct";
            }
        }
    }
}
