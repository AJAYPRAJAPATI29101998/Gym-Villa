package com.stackroute.emailservice.service;

import com.stackroute.emailservice.exception.BookingIdNotFoundException;
import com.stackroute.emailservice.exception.MailNotFoundException;
import org.springframework.mail.MailException;
import rabbitmq.domain.UserDTO;

public interface BookingMailService {
    String sendEmailToGymOwner(UserDTO userDTO) throws MailException, MailNotFoundException, BookingIdNotFoundException;
    String sendEmailToUser(UserDTO userDTO) throws MailException,MailNotFoundException,BookingIdNotFoundException;
}
