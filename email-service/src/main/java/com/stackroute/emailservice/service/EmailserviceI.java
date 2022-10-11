package com.stackroute.emailservice.service;

import com.stackroute.emailservice.pojo.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;

public interface EmailserviceI {

    String sendEmail(String recipientId,String subject,String messageBody) throws MailException;
}
