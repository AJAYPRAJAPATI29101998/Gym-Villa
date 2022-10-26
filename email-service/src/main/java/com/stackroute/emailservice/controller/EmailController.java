package com.stackroute.emailservice.controller;

import com.stackroute.emailservice.exception.MailNotFoundException;
import com.stackroute.emailservice.pojo.Email;
import com.stackroute.emailservice.service.EmailserviceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/Email-service")
public class EmailController {

    final
    EmailserviceI emailserviceI;

    public EmailController(EmailserviceI emailserviceI) {
        this.emailserviceI = emailserviceI;
    }

    @PostMapping("/sendEmail")
    public String sendEmail(@RequestBody Email email){
        try {
            return this.emailserviceI.sendSimpleMail(email);
        }catch (MailException mailException){
            return mailException.toString();
        }
    }
}
