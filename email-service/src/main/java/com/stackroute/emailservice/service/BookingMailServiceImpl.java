package com.stackroute.emailservice.service;

import com.stackroute.emailservice.exception.BookingIdNotFoundException;
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
    public String sendEmailToGymOwner(UserDTO userDTO) throws BookingIdNotFoundException,MailException , MailNotFoundException {
        Email detailsOfGymOwner=new Email();
        if(userDTO.getGymOwnerEmail().equals(null))
            throw new MailNotFoundException("Gym Owner Mail ID not present");
        detailsOfGymOwner.setRecipientId(userDTO.getGymOwnerEmail());
        if(userDTO.getBookingId()==null)
            throw new BookingIdNotFoundException("Booking ID not present");
        detailsOfGymOwner.setSubject(userDTO.getBookingId().toString());
        detailsOfGymOwner.setMessageBody("\nGym Slot Booking Details :"+
                "\nSlot ID : "+userDTO.getSlotId()+
                "\nUser Name : "+userDTO.getUserName()+
                "\nUser Email : "+userDTO.getUserEmail()+
                "\nBooking Date : "+userDTO.getDateTime()+
                "\nSubscription Plan Information : "+
                "\nSubscription ID : "+userDTO.getSubscriptionPlan().getSubscriptionId()+
                "\nSubscription Name : "+userDTO.getSubscriptionPlan().getSubscriptionName()+
                "\nSubscription Price : "+userDTO.getSubscriptionPlan().getPrice());

        return emailserviceI.sendSimpleMail(detailsOfGymOwner);

    }

    @Override
    public String sendEmailToUser(UserDTO userDTO) throws BookingIdNotFoundException,MailException ,MailNotFoundException{
        Email detailsOfUser=new Email();
        if(userDTO.getUserEmail().equals(null))
            throw new MailNotFoundException("User Mail ID not present");
        detailsOfUser.setRecipientId(userDTO.getUserEmail());
        if(userDTO.getBookingId()==null)
            throw new BookingIdNotFoundException("Booking ID not present");
        detailsOfUser.setSubject(userDTO.getBookingId().toString());
        detailsOfUser.setMessageBody("\nBooking Details :"+
                "\nSlot ID : "+userDTO.getSlotId()+
                "\nGym ID : "+userDTO.getGymOwnerId()+
                "\nBooking Date : "+userDTO.getDateTime()+
                "\nSubscription Plan Information : "+
                "\nSubscription ID : "+userDTO.getSubscriptionPlan().getSubscriptionId()+
                "\nSubscription Name : "+userDTO.getSubscriptionPlan().getSubscriptionName()+
                "\nSubscription Price : "+userDTO.getSubscriptionPlan().getPrice());

        return emailserviceI.sendSimpleMail(detailsOfUser);
    }
}
