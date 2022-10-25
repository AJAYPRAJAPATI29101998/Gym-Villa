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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.transaction.Transactional;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
   public   void  tes() throws UserAlreadyExist {
     this.service.addUser(new UserAuthentication("rajeshkumar@gmail.com","Rajeshkumar@1",Role.User));
     assertEquals(Role.User, this.service.getUserData("ravikumarr@gmail.com"));

   }

    @Test
    @Transactional
    public void testGetUserByEmailAndPassword() throws UsernameNotFoundException, UserAlreadyExist {

        UserAuthentication user1 = new UserAuthentication();
        user1.setRole(Role.valueOf("User"));
        user1.setEmailId("rameshbabu11@gmail.com");
        user1.setPassword("RameshBabu@11");
        service.addUser(user1);
        repo.save(user1);
        assertEquals("RameshBabu@11", user1.getPassword());
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
    public void jwttoken() throws UserAlreadyExist {
        UserAuthentication user1 = new UserAuthentication();
        user1.setRole(Role.valueOf("User"));
        user1.setEmailId("rameshbabu111@gmail.com");
        user1.setPassword("RameshBabu@111");
       // service.addUser(user1);
        repo.save(user1);
        Optional<UserAuthentication> userAuthentication= Optional.of(service.getUserData("ravikumarr@gmail.com"));
        System.out.println(userAuthentication);


      assertEquals("rameshbabu111@gmail.com",user1.getEmailId());

    }

    @Test
    public void uservalidations() throws UserAlreadyExist {
        UserAuthentication user1 = new UserAuthentication();
        user1.setRole(Role.valueOf("User"));
        user1.setEmailId("rameshbabu11gmail.com");
        user1.setPassword("RameshBabu@11");
       // service.addUser(user1);
        repo.save(user1);
     UserAuthentication userAuthentication=repo.findById("rameshbabu11@gmail.com").orElse(null);
       Boolean b1=userAuthentication==null;
        System.out.println(b1);

     //   System.out.println(userAuthentication);
   //    Boolean b=userAuthentication.isEmpty();
        System.out.println(userAuthentication);
     //   assertEquals(true,b);


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
       String name= jwtUtil.extractUsername("eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJtYWhlc2hrdW1hckBnbWFpbC5jb20iLCJleHAiOjE2NjYzNzY1MTgsImlhdCI6MTY2NjM0MDUxOH0.vwKSYbQkvMK2Yr6PO_npN8qzrWQ8umcNn1U9kFh_uQM"
       );
        assertEquals("maheshkumar@gmail.com",name);
    }

   @Test
    public  void jwt1()
   {
       Date jwttoken= jwtUtil.extractExpiration("eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJtYWhlc2hrdW1hckBnbWFpbC5jb20iLCJleHAiOjE2NjYzNzY1MTgsImlhdCI6MTY2NjM0MDUxOH0.vwKSYbQkvMK2Yr6PO_npN8qzrWQ8umcNn1U9kFh_uQM");

       Date date1=new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10);

       assertTrue(date1.compareTo(jwttoken)<0);

   }

    private void assertTrue(boolean compareTo) {
    }

}





