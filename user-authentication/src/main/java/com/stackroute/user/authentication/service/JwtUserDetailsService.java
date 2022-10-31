package com.stackroute.user.authentication.service;



import com.stackroute.user.authentication.entity.Role;
import com.stackroute.user.authentication.entity.UserAuthentication;
import com.stackroute.user.authentication.exceptions.UserAlreadyExist;
import com.stackroute.user.authentication.repository.UserAuthenticationRepository;
import com.stackroute.user.authentication.utill.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
@Slf4j
public class JwtUserDetailsService implements UserDetailsService,UserAuthenticationService {
    @Autowired
    UserAuthenticationRepository userAuthenticationRepository;

    @Autowired
    JwtUtil jwtUtil;



    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
       UserAuthentication existinguserAuthentication1= userAuthenticationRepository.findById(s).orElse(null);

        try {


            return new User(existinguserAuthentication1.getEmailId(),existinguserAuthentication1.getPassword(),new ArrayList<>());

        }
        catch (Exception e)
        {
            throw new UsernameNotFoundException("user not found");
        }
    }

    @Override
    public UserAuthentication addUser(UserAuthentication user) throws UserAlreadyExist {
        Optional<UserAuthentication> userAuthentication=userAuthenticationRepository.findById(user.getEmailId());
        if(userAuthentication.isPresent())
        {
            throw new UserAlreadyExist();
        }
     else {
            log.info("adding the new email{} into the Database", user.getEmailId());
          UserAuthentication existingUser=new UserAuthentication();
          existingUser.setRole(user.getRole());
          existingUser.setEmailId(user.getEmailId());
          existingUser.setPassword(user.getPassword());
            return userAuthenticationRepository.save(existingUser);
        }




    }



    @Override
    public Role getRole(String emailId) {
        UserAuthentication userAuthentication=userAuthenticationRepository.findById(emailId).orElseThrow(()->new UsernameNotFoundException(""));

        return userAuthentication.getRole();
    }

    @Override
    public UserAuthentication getUserData(String emailId) {
        return userAuthenticationRepository.findById(emailId).orElse(null);
    }


}