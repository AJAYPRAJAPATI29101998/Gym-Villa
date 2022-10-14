package com.stackroute.emailservice.service;

import com.stackroute.emailservice.exception.MailNotFoundException;
import com.stackroute.emailservice.pojo.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import rabbitmq.domain.UserDTO;

public interface EmailserviceI{

    String sendSimpleMail(Email details) throws MailException;
}
