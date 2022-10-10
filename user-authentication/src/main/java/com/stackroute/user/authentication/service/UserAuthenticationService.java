package com.stackroute.user.authentication.service;

import com.stackroute.user.authentication.entity.UserAuthentication;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;
import java.util.Optional;

public interface UserAuthenticationService {
  UserAuthentication addUser(UserAuthentication user);

  public UserDetails loadUserByUsername(String s);

  List<UserAuthentication> getAllUsers();

//
//  String loginuser(UserAuthentication user);
//  Optional<UserAuthentication> getUser(String email);
}
