package com.stackroute.emailservice.service;


import com.stackroute.emailservice.pojo.Email;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.springframework.test.util.AssertionErrors.assertEquals;

@ContextConfiguration(classes = {EmailServiceImpl.class})
@ExtendWith(SpringExtension.class)
public class EmailServiceTest {

    @Autowired
    private EmailServiceImpl emailService;

    @MockBean
    private JavaMailSender javaMailSender;

//    @Test
//    void testSendEMail(){
//        doNothing().when(javaMailSender).send((SimpleMailMessage) any());
//        assertEquals("Mail sent successfully", emailService.sendEmail("pratikmench@gmail.com","junit","junit testing"));
//        verify(javaMailSender).send((SimpleMailMessage) any());
//    }
}
