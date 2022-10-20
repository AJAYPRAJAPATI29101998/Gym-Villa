//package com.stackroute.emailservice.controller;
//
//import static org.mockito.Mockito.any;
//import static org.mockito.Mockito.when;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.stackroute.emailservice.pojo.Email;
//import com.stackroute.emailservice.service.EmailserviceI;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.mail.MailAuthenticationException;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//
//@ContextConfiguration(classes = {EmailController.class})
//@ExtendWith(SpringExtension.class)
//class EmailControllerTest {
//    @Autowired
//    private EmailController emailController;
//
//    @MockBean
//    private EmailserviceI emailserviceI;
//
//
//    @Test
//    void testSendEmail() throws Exception {
//        when(emailserviceI.sendSimpleMail((Email) any())).thenReturn("Send Simple Mail");
//
//        Email email = new Email();
//        email.setMessageBody("Not all who wander are lost");
//        email.setRecipientId("42");
//        email.setSubject("Hello from the Dreaming Spires");
//        String content = (new ObjectMapper()).writeValueAsString(email);
//        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/sendEmail")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(content);
//        MockMvcBuilders.standaloneSetup(emailController)
//                .build()
//                .perform(requestBuilder)
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
//                .andExpect(MockMvcResultMatchers.content().string("Send Simple Mail"));
//    }
//
//
//    @Test
//    void testSendEmail2() throws Exception {
//        when(emailserviceI.sendSimpleMail((Email) any())).thenThrow(new MailAuthenticationException("?"));
//
//        Email email = new Email();
//        email.setMessageBody("Not all who wander are lost");
//        email.setRecipientId("42");
//        email.setSubject("Hello from the Dreaming Spires");
//        String content = (new ObjectMapper()).writeValueAsString(email);
//        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/sendEmail")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(content);
//        MockMvcBuilders.standaloneSetup(emailController)
//                .build()
//                .perform(requestBuilder)
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
//                .andExpect(MockMvcResultMatchers.content().string("org.springframework.mail.MailAuthenticationException: ?"));
//    }
//}
//
