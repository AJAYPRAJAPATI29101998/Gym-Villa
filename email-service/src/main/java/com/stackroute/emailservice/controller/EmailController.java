package com.stackroute.emailservice.controller;

import com.stackroute.emailservice.pojo.Email;
import com.stackroute.emailservice.service.EmailserviceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmailController {

    final
    EmailserviceI emailserviceI;

    public EmailController(EmailserviceI emailserviceI) {
        this.emailserviceI = emailserviceI;
    }

    @PostMapping("/sendEmail")
    public String sendEmail(@RequestBody Email email){
        return this.emailserviceI.sendEmail(email.getRecipientId(),email.getSubject(),email.getMessageBody());
    }
}
