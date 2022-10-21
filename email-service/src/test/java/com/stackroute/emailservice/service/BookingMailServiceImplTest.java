//package com.stackroute.emailservice.service;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertThrows;
//import static org.mockito.Mockito.any;
//import static org.mockito.Mockito.anyInt;
//import static org.mockito.Mockito.atLeast;
//import static org.mockito.Mockito.doNothing;
//import static org.mockito.Mockito.mock;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//
//import com.stackroute.emailservice.exception.BookingIdNotFoundException;
//import com.stackroute.emailservice.exception.MailNotFoundException;
//import com.stackroute.emailservice.pojo.Email;
//import com.stackroute.emailservice.pojo.GymSubscription;
//
//import java.time.LocalDateTime;
//
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.mail.MailAuthenticationException;
//import org.springframework.mail.MailException;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//import rabbitmq.domain.UserDTO;
//
//@ContextConfiguration(classes = {BookingMailServiceImpl.class})
//@ExtendWith(SpringExtension.class)
//class BookingMailServiceImplTest {
//    @Autowired
//    private BookingMailServiceImpl bookingMailServiceImpl;
//
//    @MockBean
//    private EmailserviceI emailserviceI;
//
//
//    @Test
//    void testSendEmailToGymOwner() throws BookingIdNotFoundException, MailNotFoundException, MailException {
//        when(emailserviceI.sendSimpleMail((Email) any())).thenReturn("Send Simple Mail");
//
//        UserDTO userDTO = new UserDTO();
//        userDTO.setBookingId(123);
//        userDTO.setDateTime(LocalDateTime.of(1, 1, 1, 1, 1));
//        userDTO.setGymOwnerEmail("jane.doe@example.org");
//        userDTO.setGymOwnerId(123);
//        userDTO.setSlotId(123);
//        userDTO.setSubscriptionPlan(new GymSubscription());
//        userDTO.setUserEmail("jane.doe@example.org");
//        userDTO.setUserName("janedoe");
//        assertEquals("Send Simple Mail", bookingMailServiceImpl.sendEmailToGymOwner(userDTO));
//        verify(emailserviceI).sendSimpleMail((Email) any());
//    }
//
//
//    @Test
//    void testSendEmailToGymOwner2() throws BookingIdNotFoundException, MailNotFoundException, MailException {
//        when(emailserviceI.sendSimpleMail((Email) any())).thenReturn("Send Simple Mail");
//        UserDTO userDTO = mock(UserDTO.class);
//        when(userDTO.getSubscriptionPlan()).thenReturn(new GymSubscription());
//        when(userDTO.getSlotId()).thenReturn(123);
//        when(userDTO.getBookingId()).thenReturn(123);
//        when(userDTO.getUserEmail()).thenReturn("jane.doe@example.org");
//        when(userDTO.getUserName()).thenReturn("janedoe");
//        when(userDTO.getDateTime()).thenReturn(LocalDateTime.of(1, 1, 1, 1, 1));
//        when(userDTO.getGymOwnerEmail()).thenReturn("jane.doe@example.org");
//        doNothing().when(userDTO).setBookingId((Integer) any());
//        doNothing().when(userDTO).setDateTime((LocalDateTime) any());
//        doNothing().when(userDTO).setGymOwnerEmail((String) any());
//        doNothing().when(userDTO).setGymOwnerId((Integer) any());
//        doNothing().when(userDTO).setSlotId(anyInt());
//        doNothing().when(userDTO).setSubscriptionPlan((GymSubscription) any());
//        doNothing().when(userDTO).setUserEmail((String) any());
//        doNothing().when(userDTO).setUserName((String) any());
//        userDTO.setBookingId(123);
//        userDTO.setDateTime(LocalDateTime.of(1, 1, 1, 1, 1));
//        userDTO.setGymOwnerEmail("jane.doe@example.org");
//        userDTO.setGymOwnerId(123);
//        userDTO.setSlotId(123);
//        userDTO.setSubscriptionPlan(new GymSubscription());
//        userDTO.setUserEmail("jane.doe@example.org");
//        userDTO.setUserName("janedoe");
//        assertEquals("Send Simple Mail", bookingMailServiceImpl.sendEmailToGymOwner(userDTO));
//        verify(emailserviceI).sendSimpleMail((Email) any());
//        verify(userDTO, atLeast(1)).getSubscriptionPlan();
//        verify(userDTO).getSlotId();
//        verify(userDTO, atLeast(1)).getBookingId();
//        verify(userDTO, atLeast(1)).getGymOwnerEmail();
//        verify(userDTO).getUserEmail();
//        verify(userDTO).getUserName();
//        verify(userDTO).getDateTime();
//        verify(userDTO).setBookingId((Integer) any());
//        verify(userDTO).setDateTime((LocalDateTime) any());
//        verify(userDTO).setGymOwnerEmail((String) any());
//        verify(userDTO).setGymOwnerId((Integer) any());
//        verify(userDTO).setSlotId(anyInt());
//        verify(userDTO).setSubscriptionPlan((GymSubscription) any());
//        verify(userDTO).setUserEmail((String) any());
//        verify(userDTO).setUserName((String) any());
//    }
//
//
//    @Test
//    void testSendEmailToGymOwner3() throws BookingIdNotFoundException, MailNotFoundException, MailException {
//        when(emailserviceI.sendSimpleMail((Email) any())).thenReturn("Send Simple Mail");
//        UserDTO userDTO = mock(UserDTO.class);
//        when(userDTO.getSubscriptionPlan()).thenThrow(new MailAuthenticationException("Msg"));
//        when(userDTO.getSlotId()).thenThrow(new MailAuthenticationException("Msg"));
//        when(userDTO.getBookingId()).thenThrow(new MailAuthenticationException("Msg"));
//        when(userDTO.getUserEmail()).thenThrow(new MailAuthenticationException("Msg"));
//        when(userDTO.getUserName()).thenThrow(new MailAuthenticationException("Msg"));
//        when(userDTO.getDateTime()).thenThrow(new MailAuthenticationException("Msg"));
//        when(userDTO.getGymOwnerEmail()).thenReturn("jane.doe@example.org");
//        doNothing().when(userDTO).setBookingId((Integer) any());
//        doNothing().when(userDTO).setDateTime((LocalDateTime) any());
//        doNothing().when(userDTO).setGymOwnerEmail((String) any());
//        doNothing().when(userDTO).setGymOwnerId((Integer) any());
//        doNothing().when(userDTO).setSlotId(anyInt());
//        doNothing().when(userDTO).setSubscriptionPlan((GymSubscription) any());
//        doNothing().when(userDTO).setUserEmail((String) any());
//        doNothing().when(userDTO).setUserName((String) any());
//        userDTO.setBookingId(123);
//        userDTO.setDateTime(LocalDateTime.of(1, 1, 1, 1, 1));
//        userDTO.setGymOwnerEmail("jane.doe@example.org");
//        userDTO.setGymOwnerId(123);
//        userDTO.setSlotId(123);
//        userDTO.setSubscriptionPlan(new GymSubscription());
//        userDTO.setUserEmail("jane.doe@example.org");
//        userDTO.setUserName("janedoe");
//        assertThrows(MailAuthenticationException.class, () -> bookingMailServiceImpl.sendEmailToGymOwner(userDTO));
//        verify(userDTO).getBookingId();
//        verify(userDTO, atLeast(1)).getGymOwnerEmail();
//        verify(userDTO).setBookingId((Integer) any());
//        verify(userDTO).setDateTime((LocalDateTime) any());
//        verify(userDTO).setGymOwnerEmail((String) any());
//        verify(userDTO).setGymOwnerId((Integer) any());
//        verify(userDTO).setSlotId(anyInt());
//        verify(userDTO).setSubscriptionPlan((GymSubscription) any());
//        verify(userDTO).setUserEmail((String) any());
//        verify(userDTO).setUserName((String) any());
//    }
//
//
//
//
//    @Test
//    void testSendEmailToGymOwner5() throws BookingIdNotFoundException, MailNotFoundException, MailException {
//        when(emailserviceI.sendSimpleMail((Email) any())).thenReturn("Send Simple Mail");
//        UserDTO userDTO = mock(UserDTO.class);
//        when(userDTO.getSubscriptionPlan()).thenReturn(new GymSubscription());
//        when(userDTO.getSlotId()).thenReturn(123);
//        when(userDTO.getBookingId()).thenReturn(null);
//        when(userDTO.getUserEmail()).thenReturn("jane.doe@example.org");
//        when(userDTO.getUserName()).thenReturn("janedoe");
//        when(userDTO.getDateTime()).thenReturn(LocalDateTime.of(1, 1, 1, 1, 1));
//        when(userDTO.getGymOwnerEmail()).thenReturn("jane.doe@example.org");
//        doNothing().when(userDTO).setBookingId((Integer) any());
//        doNothing().when(userDTO).setDateTime((LocalDateTime) any());
//        doNothing().when(userDTO).setGymOwnerEmail((String) any());
//        doNothing().when(userDTO).setGymOwnerId((Integer) any());
//        doNothing().when(userDTO).setSlotId(anyInt());
//        doNothing().when(userDTO).setSubscriptionPlan((GymSubscription) any());
//        doNothing().when(userDTO).setUserEmail((String) any());
//        doNothing().when(userDTO).setUserName((String) any());
//        userDTO.setBookingId(123);
//        userDTO.setDateTime(LocalDateTime.of(1, 1, 1, 1, 1));
//        userDTO.setGymOwnerEmail("jane.doe@example.org");
//        userDTO.setGymOwnerId(123);
//        userDTO.setSlotId(123);
//        userDTO.setSubscriptionPlan(new GymSubscription());
//        userDTO.setUserEmail("jane.doe@example.org");
//        userDTO.setUserName("janedoe");
//        assertThrows(BookingIdNotFoundException.class, () -> bookingMailServiceImpl.sendEmailToGymOwner(userDTO));
//        verify(userDTO).getBookingId();
//        verify(userDTO, atLeast(1)).getGymOwnerEmail();
//        verify(userDTO).setBookingId((Integer) any());
//        verify(userDTO).setDateTime((LocalDateTime) any());
//        verify(userDTO).setGymOwnerEmail((String) any());
//        verify(userDTO).setGymOwnerId((Integer) any());
//        verify(userDTO).setSlotId(anyInt());
//        verify(userDTO).setSubscriptionPlan((GymSubscription) any());
//        verify(userDTO).setUserEmail((String) any());
//        verify(userDTO).setUserName((String) any());
//    }
//
//
//
//    @Test
//    void testSendEmailToUser() throws BookingIdNotFoundException, MailNotFoundException, MailException {
//        when(emailserviceI.sendSimpleMail((Email) any())).thenReturn("Send Simple Mail");
//
//        UserDTO userDTO = new UserDTO();
//        userDTO.setBookingId(123);
//        userDTO.setDateTime(LocalDateTime.of(1, 1, 1, 1, 1));
//        userDTO.setGymOwnerEmail("jane.doe@example.org");
//        userDTO.setGymOwnerId(123);
//        userDTO.setSlotId(123);
//        userDTO.setSubscriptionPlan(new GymSubscription());
//        userDTO.setUserEmail("jane.doe@example.org");
//        userDTO.setUserName("janedoe");
//        assertEquals("Send Simple Mail", bookingMailServiceImpl.sendEmailToUser(userDTO));
//        verify(emailserviceI).sendSimpleMail((Email) any());
//    }
//
//
//    @Test
//    void testSendEmailToUser2() throws BookingIdNotFoundException, MailNotFoundException, MailException {
//        when(emailserviceI.sendSimpleMail((Email) any())).thenReturn("Send Simple Mail");
//        UserDTO userDTO = mock(UserDTO.class);
//        when(userDTO.getSubscriptionPlan()).thenReturn(new GymSubscription());
//        when(userDTO.getSlotId()).thenReturn(123);
//        when(userDTO.getBookingId()).thenReturn(123);
//        when(userDTO.getGymOwnerId()).thenReturn(123);
//        when(userDTO.getDateTime()).thenReturn(LocalDateTime.of(1, 1, 1, 1, 1));
//        when(userDTO.getUserEmail()).thenReturn("jane.doe@example.org");
//        doNothing().when(userDTO).setBookingId((Integer) any());
//        doNothing().when(userDTO).setDateTime((LocalDateTime) any());
//        doNothing().when(userDTO).setGymOwnerEmail((String) any());
//        doNothing().when(userDTO).setGymOwnerId((Integer) any());
//        doNothing().when(userDTO).setSlotId(anyInt());
//        doNothing().when(userDTO).setSubscriptionPlan((GymSubscription) any());
//        doNothing().when(userDTO).setUserEmail((String) any());
//        doNothing().when(userDTO).setUserName((String) any());
//        userDTO.setBookingId(123);
//        userDTO.setDateTime(LocalDateTime.of(1, 1, 1, 1, 1));
//        userDTO.setGymOwnerEmail("jane.doe@example.org");
//        userDTO.setGymOwnerId(123);
//        userDTO.setSlotId(123);
//        userDTO.setSubscriptionPlan(new GymSubscription());
//        userDTO.setUserEmail("jane.doe@example.org");
//        userDTO.setUserName("janedoe");
//        assertEquals("Send Simple Mail", bookingMailServiceImpl.sendEmailToUser(userDTO));
//        verify(emailserviceI).sendSimpleMail((Email) any());
//        verify(userDTO, atLeast(1)).getSubscriptionPlan();
//        verify(userDTO).getSlotId();
//        verify(userDTO, atLeast(1)).getBookingId();
//        verify(userDTO).getGymOwnerId();
//        verify(userDTO, atLeast(1)).getUserEmail();
//        verify(userDTO).getDateTime();
//        verify(userDTO).setBookingId((Integer) any());
//        verify(userDTO).setDateTime((LocalDateTime) any());
//        verify(userDTO).setGymOwnerEmail((String) any());
//        verify(userDTO).setGymOwnerId((Integer) any());
//        verify(userDTO).setSlotId(anyInt());
//        verify(userDTO).setSubscriptionPlan((GymSubscription) any());
//        verify(userDTO).setUserEmail((String) any());
//        verify(userDTO).setUserName((String) any());
//    }
//
//
//    @Test
//    void testSendEmailToUser3() throws BookingIdNotFoundException, MailNotFoundException, MailException {
//        when(emailserviceI.sendSimpleMail((Email) any())).thenReturn("Send Simple Mail");
//        UserDTO userDTO = mock(UserDTO.class);
//        when(userDTO.getSubscriptionPlan()).thenThrow(new MailAuthenticationException("Msg"));
//        when(userDTO.getSlotId()).thenThrow(new MailAuthenticationException("Msg"));
//        when(userDTO.getBookingId()).thenThrow(new MailAuthenticationException("Msg"));
//        when(userDTO.getGymOwnerId()).thenThrow(new MailAuthenticationException("Msg"));
//        when(userDTO.getDateTime()).thenThrow(new MailAuthenticationException("Msg"));
//        when(userDTO.getUserEmail()).thenReturn("jane.doe@example.org");
//        doNothing().when(userDTO).setBookingId((Integer) any());
//        doNothing().when(userDTO).setDateTime((LocalDateTime) any());
//        doNothing().when(userDTO).setGymOwnerEmail((String) any());
//        doNothing().when(userDTO).setGymOwnerId((Integer) any());
//        doNothing().when(userDTO).setSlotId(anyInt());
//        doNothing().when(userDTO).setSubscriptionPlan((GymSubscription) any());
//        doNothing().when(userDTO).setUserEmail((String) any());
//        doNothing().when(userDTO).setUserName((String) any());
//        userDTO.setBookingId(123);
//        userDTO.setDateTime(LocalDateTime.of(1, 1, 1, 1, 1));
//        userDTO.setGymOwnerEmail("jane.doe@example.org");
//        userDTO.setGymOwnerId(123);
//        userDTO.setSlotId(123);
//        userDTO.setSubscriptionPlan(new GymSubscription());
//        userDTO.setUserEmail("jane.doe@example.org");
//        userDTO.setUserName("janedoe");
//        assertThrows(MailAuthenticationException.class, () -> bookingMailServiceImpl.sendEmailToUser(userDTO));
//        verify(userDTO).getBookingId();
//        verify(userDTO, atLeast(1)).getUserEmail();
//        verify(userDTO).setBookingId((Integer) any());
//        verify(userDTO).setDateTime((LocalDateTime) any());
//        verify(userDTO).setGymOwnerEmail((String) any());
//        verify(userDTO).setGymOwnerId((Integer) any());
//        verify(userDTO).setSlotId(anyInt());
//        verify(userDTO).setSubscriptionPlan((GymSubscription) any());
//        verify(userDTO).setUserEmail((String) any());
//        verify(userDTO).setUserName((String) any());
//    }
//
//
//
//    @Test
//    void testSendEmailToUser5() throws BookingIdNotFoundException, MailNotFoundException, MailException {
//        when(emailserviceI.sendSimpleMail((Email) any())).thenReturn("Send Simple Mail");
//        UserDTO userDTO = mock(UserDTO.class);
//        when(userDTO.getSubscriptionPlan()).thenReturn(new GymSubscription());
//        when(userDTO.getSlotId()).thenReturn(123);
//        when(userDTO.getBookingId()).thenReturn(null);
//        when(userDTO.getGymOwnerId()).thenReturn(123);
//        when(userDTO.getDateTime()).thenReturn(LocalDateTime.of(1, 1, 1, 1, 1));
//        when(userDTO.getUserEmail()).thenReturn("jane.doe@example.org");
//        doNothing().when(userDTO).setBookingId((Integer) any());
//        doNothing().when(userDTO).setDateTime((LocalDateTime) any());
//        doNothing().when(userDTO).setGymOwnerEmail((String) any());
//        doNothing().when(userDTO).setGymOwnerId((Integer) any());
//        doNothing().when(userDTO).setSlotId(anyInt());
//        doNothing().when(userDTO).setSubscriptionPlan((GymSubscription) any());
//        doNothing().when(userDTO).setUserEmail((String) any());
//        doNothing().when(userDTO).setUserName((String) any());
//        userDTO.setBookingId(123);
//        userDTO.setDateTime(LocalDateTime.of(1, 1, 1, 1, 1));
//        userDTO.setGymOwnerEmail("jane.doe@example.org");
//        userDTO.setGymOwnerId(123);
//        userDTO.setSlotId(123);
//        userDTO.setSubscriptionPlan(new GymSubscription());
//        userDTO.setUserEmail("jane.doe@example.org");
//        userDTO.setUserName("janedoe");
//        assertThrows(BookingIdNotFoundException.class, () -> bookingMailServiceImpl.sendEmailToUser(userDTO));
//        verify(userDTO).getBookingId();
//        verify(userDTO, atLeast(1)).getUserEmail();
//        verify(userDTO).setBookingId((Integer) any());
//        verify(userDTO).setDateTime((LocalDateTime) any());
//        verify(userDTO).setGymOwnerEmail((String) any());
//        verify(userDTO).setGymOwnerId((Integer) any());
//        verify(userDTO).setSlotId(anyInt());
//        verify(userDTO).setSubscriptionPlan((GymSubscription) any());
//        verify(userDTO).setUserEmail((String) any());
//        verify(userDTO).setUserName((String) any());
//    }
//
//
//}
//
