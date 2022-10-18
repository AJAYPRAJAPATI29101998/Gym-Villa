package com.stackroute.user.authentication.service;

import com.stackroute.user.authentication.entity.Role;
import com.stackroute.user.authentication.entity.UserAuthentication;
import com.stackroute.user.authentication.exceptions.UserAlreadyExist;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface UserAuthenticationService {
  UserAuthentication addUser(UserAuthentication user) throws UserAlreadyExist;

  public UserDetails loadUserByUsername(String s);



  public Role getRole(String emialId);


}
