package com.stackroute.user.authentication.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.stackroute.user.authentication.controller.UserAuthenticationController;
import com.stackroute.user.authentication.entity.Role;
import com.stackroute.user.authentication.entity.UserAuthentication;
import com.stackroute.user.authentication.repository.UserAuthenticationRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;


import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.notNullValue;


import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(MockitoJUnitRunner.class)
public class Service {
    private MockMvc mockMvc;

    ObjectMapper objectMapper=new ObjectMapper();

    ObjectWriter objectWriter=objectMapper.writer();

    @Mock
    private UserAuthenticationRepository userAuthenticationRepository;
    @InjectMocks
    private UserAuthenticationController userAuthenticationController;

    UserAuthentication userAuthentication=new UserAuthentication("harishkumar@gmail.com","Harishkumar@1", Role.User);
    UserAuthentication userAuthentication1=new UserAuthentication("ganeshkumar@gmail.com","Ganeshkumar@1", Role.GymOwner);
    UserAuthentication userAuthentication2=new UserAuthentication("raheman@gmail.com","Rahemanr@1", Role.User);

  @Before
    public  void setup()
  {
     // MockitoAnnotations.openMocks(this);
      MockitoAnnotations.initMocks(this);
      this.mockMvc= MockMvcBuilders.standaloneSetup(userAuthenticationController).build();
  }

  @Test
    public void getname() throws Exception {
      List<UserAuthentication> usersData=new ArrayList<>(Arrays.asList(userAuthentication,userAuthentication1,userAuthentication2));

     // String emailid="harishkumar@gmail.com";
      UserAuthentication userAuthentication3=new UserAuthentication();
      Mockito.when(userAuthenticationRepository.findById(userAuthentication.getEmailId())).thenReturn(Optional.of(userAuthentication));

      mockMvc.perform(MockMvcRequestBuilders
                      .get("/details/harishkumar@gmail.com")
              .contentType(MediaType.APPLICATION_JSON))
              .andExpect(status().isOk())

              .andExpect(jsonPath("$",notNullValue()))
              .andExpect((ResultMatcher) jsonPath("$.password",is("harishkumar@gmail.com")));
  }



}
