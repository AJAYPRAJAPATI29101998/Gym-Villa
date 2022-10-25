package com.stackroute.usersevice.service;

import com.stackroute.usersevice.exceptions.UserNotPresent;
import com.stackroute.usersevice.model.User;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {
    ResponseEntity<?> saveUser(User user);
    User getUserByEmail(String email) throws UserNotPresent;
    List<User> getAllUsers() throws UserNotPresent;

    String deleteUserByEmail(String email) throws UserNotPresent;
}
