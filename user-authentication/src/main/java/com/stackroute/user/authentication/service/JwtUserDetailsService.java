package com.stackroute.user.authentication.service;



import com.stackroute.user.authentication.entity.UserAuthentication;
import com.stackroute.user.authentication.repository.UserAuthenticationRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@Slf4j
public class JwtUserDetailsService implements UserDetailsService,UserAuthenticationService {
    @Autowired
    UserAuthenticationRepository userAuthenticationRepository;



    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        UserAuthentication existinguserAuthentication1=userAuthenticationRepository.findById(s)
                .orElseThrow(()->new UsernameNotFoundException("user not found"));
        return new User(existinguserAuthentication1.getEmailId(),existinguserAuthentication1.getPassword(),new ArrayList<>());
    }

    @Override
    public UserAuthentication addUser(UserAuthentication user) {

        log.info("adding the new email{} into the Database", user.getEmailId());
        return userAuthenticationRepository.save(user);

    }

    @Override
    public List<UserAuthentication> getAllUsers() {

        log.info("getting the users from the database");
        return userAuthenticationRepository.findAll();
    }
}