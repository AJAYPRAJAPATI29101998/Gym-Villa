package com.stackroute.emailservice.service;

import com.stackroute.emailservice.exception.MailNotFoundException;
import com.stackroute.emailservice.pojo.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import rabbitmq.domain.UserDTO;


@Service
public class BookingMailServiceImpl implements BookingMailService{

    @Autowired
    private EmailserviceI emailserviceI;

    @Override
    public String sendEmailToGymOwner(UserDTO userDTO) throws MailException , MailNotFoundException {
        Email detailsOfGymOwner=new Email();
        if(userDTO.getGymOwnerEmail().equals(null))
            throw new MailNotFoundException("Gym Owner Mail ID not present");
        detailsOfGymOwner.setRecipientId(userDTO.getGymOwnerEmail());
        detailsOfGymOwner.setSubject(userDTO.getBookingId());
        detailsOfGymOwner.setMessageBody("\nGym Slot Booking Details :"+
                "\nUser Name : "+userDTO.getUserName()+
                "\nUser Email : "+userDTO.getUserEmail()+
                "\nBooking Date : "+userDTO.getBookingDate()+
                "\nSubscription Plan Information : "+userDTO.getSubscriptionPlan()+
                "\nSlot Information : "+userDTO.getSlotInfo());

        return emailserviceI.sendSimpleMail(detailsOfGymOwner);

    }

    @Override
    public String sendEmailToUser(UserDTO userDTO) throws MailException ,MailNotFoundException{
        Email detailsOfUser=new Email();
        if(userDTO.getUserEmail().equals(null))
            throw new MailNotFoundException("User Mail ID not present");
        detailsOfUser.setRecipientId(userDTO.getUserEmail());
        detailsOfUser.setSubject(userDTO.getBookingId());
        detailsOfUser.setMessageBody("\nBooking Details :"+
                "\nGym ID : "+userDTO.getGymId()+
                "\nBooking Date : "+userDTO.getBookingDate()+
                "\nSubscription Plan Information : "+userDTO.getSubscriptionPlan()+
                "\nSlot Information : "+userDTO.getSlotInfo());

        return emailserviceI.sendSimpleMail(detailsOfUser);
    }
}
