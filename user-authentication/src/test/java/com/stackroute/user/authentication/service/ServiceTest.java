package com.stackroute.user.authentication.service;

import com.stackroute.user.authentication.controller.UserAuthenticationController;
import com.stackroute.user.authentication.entity.Role;
import com.stackroute.user.authentication.entity.UserAuthentication;
import com.stackroute.user.authentication.exceptions.UserAlreadyExist;
import com.stackroute.user.authentication.exceptions.UsernameNotFoundException;
import com.stackroute.user.authentication.repository.UserAuthenticationRepository;
import com.stackroute.user.authentication.utill.JwtUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class ServiceTest {
    @InjectMocks
    public JwtUserDetailsService service;
    @Mock
    public UserAuthenticationRepository repo;

    @Autowired
    UserAuthenticationController userAuthenticationController;

    @Autowired
    JwtUtil jwtUtil=new JwtUtil();


//    UserAuthentication user=new UserAuthentication();


    @Test
    public void testGetUserByEmailAndPassword() throws UsernameNotFoundException, UserAlreadyExist {

        UserAuthentication user1 = new UserAuthentication();
        user1.setRole(Role.valueOf("User"));
        user1.setEmailId("rameshbabu11@gmail.com");
        user1.setPassword("RameshBabu@11");
        repo.save(user1);
        assertEquals(Role.User, user1.getRole());
    }

//    @Test
//    public void testWhenCredintialsValid() throws UsernameNotFoundException {
//        new User("rameshbabu11@gmail.com","RameshBabu@11");
//        user.setUserEmail("akhil6500s@gmail.com");
//        user.setUserPassword("12345");
//        Map<String, String> map = new HashMap<>();
//        map.put("authenticated", "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJyYXZlZW5hbjY1MDBzQGdtYWlsLmNvbSIsImlhdCI6MTY1NzYyNzQ5OH0.Ht_zErswfO3E22RVHrxVFkp6LuZMHUl_Tj-sFHn3sS4");
//        entity = new ResponseEntity(map, HttpStatus.OK);
//
//        Mockito.when(service.login(anyString(), anyString())).thenReturn(user);
//        Mockito.when(token.generateToken(user)).thenReturn(map);
//
//        assertEquals(entity, controller.login(user));
//
//
//    }

    @Test
    public void jwttoken() {
        UserAuthentication user1 = new UserAuthentication();
        user1.setRole(Role.valueOf("User"));
        user1.setEmailId("rameshbabu11@gmail.com");
        user1.setPassword("RameshBabu@11");
        repo.save(user1);
        Optional<UserAuthentication> userAuthentication=repo.findById("rameshbabu11@gmail.com");
        assertTrue(userAuthentication.isEmpty());

    }

    @Test
    public void uservalidations() throws UserAlreadyExist {
        UserAuthentication user1 = new UserAuthentication();
        user1.setRole(Role.valueOf("User"));
        user1.setEmailId("rameshbabu11gmail.com");
        user1.setPassword("RameshBabu@11");
        service.addUser(user1);
       // repo.save(user1);
        Optional<UserAuthentication> userAuthentication=repo.findById("rameshbabu11@gmail.com");
        assertTrue(userAuthentication.isEmpty());


    }


//    @Test
//    public void jwtTokenValidation() throws UsernameNotFoundException
//    {
//        HttpServletRequest httpServletRequest ;
//       // httpServletRequest=eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJyYXZpa3VtYXJAZ21haWwuY29tIiwiZXhwIjoxNjY2MTc4Mzc2LCJpYXQiOjE2NjYxNDIzNzZ9.fUNKDVtbCC87vQSpefaBn7ABKKouCO4YggoJiQPLX8U";
//        UserAuthentication userAuthentication= (UserAuthentication) service.loadUserByUsername("rameshbabu11@gmail.com");
//        new User(userAuthentication.getEmailId(),userAuthentication.getPassword(),new ArrayList<>());
//      //  userAuthenticationController.gettingRole(eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJyYXZpa3VtYXJAZ21haWwuY29tIiwiZXhwIjoxNjY2MTc4Mzc2LCJpYXQiOjE2NjYxNDIzNzZ9.fUNKDVtbCC87vQSpefaBn7ABKKouCO4YggoJiQPLX8U);
//
//    }

    @Test
    public  void jwt()
    {
       String name= jwtUtil.extractUsername("eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJyYXZpa3VtYXJAZ21haWwuY29tIiwiZXhwIjoxNjY2MTc4Mzc2LCJpYXQiOjE2NjYxNDIzNzZ9.fUNKDVtbCC87vQSpefaBn7ABKKouCO4YggoJiQPLX8U");
        assertEquals("ravikumar@gmail.com",name);
    }


}





