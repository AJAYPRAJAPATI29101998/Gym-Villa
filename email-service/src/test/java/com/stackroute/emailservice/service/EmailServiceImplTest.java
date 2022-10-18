package com.stackroute.emailservice.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.stackroute.emailservice.pojo.Email;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {EmailServiceImpl.class})
@ExtendWith(SpringExtension.class)
class EmailServiceImplTest {
    @Autowired
    private EmailServiceImpl emailServiceImpl;

    @MockBean
    private JavaMailSender javaMailSender;


    @Test
    void testSendSimpleMail() throws MailException {
        doNothing().when(javaMailSender).send((SimpleMailMessage) any());

        Email email = new Email();
        email.setMessageBody("Not all who wander are lost");
        email.setRecipientId("42");
        email.setSubject("Hello from the Dreaming Spires");
        assertEquals("Mail sent successfully", emailServiceImpl.sendSimpleMail(email));
        verify(javaMailSender).send((SimpleMailMessage) any());
    }


    @Test
    void testSendSimpleMail2() throws MailException {
        doNothing().when(javaMailSender).send((SimpleMailMessage) any());
        Email email = mock(Email.class);
        when(email.getMessageBody()).thenReturn("Not all who wander are lost");
        when(email.getRecipientId()).thenReturn("42");
        when(email.getSubject()).thenReturn("Hello from the Dreaming Spires");
        doNothing().when(email).setMessageBody((String) any());
        doNothing().when(email).setRecipientId((String) any());
        doNothing().when(email).setSubject((String) any());
        email.setMessageBody("Not all who wander are lost");
        email.setRecipientId("42");
        email.setSubject("Hello from the Dreaming Spires");
        assertEquals("Mail sent successfully", emailServiceImpl.sendSimpleMail(email));
        verify(javaMailSender).send((SimpleMailMessage) any());
        verify(email).getMessageBody();
        verify(email).getRecipientId();
        verify(email).getSubject();
        verify(email).setMessageBody((String) any());
        verify(email).setRecipientId((String) any());
        verify(email).setSubject((String) any());
    }
}

