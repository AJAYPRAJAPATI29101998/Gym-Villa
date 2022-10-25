package com.stackroute.usersevice.controller;

import com.stackroute.usersevice.exceptions.UserNotPresent;
import com.stackroute.usersevice.model.User;
import com.stackroute.usersevice.service.UserServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class UserController {
    @Autowired
    private UserServiceImplementation userService;

    @PostMapping("/user")
    public ResponseEntity<?> saveUser(@Valid @RequestBody User user){
        return this.userService.saveUser(user);
    }

    @GetMapping("/users")
    private ResponseEntity<?> getAllUsers() {
        try {
            return new ResponseEntity<>(this.userService.getAllUsers(), HttpStatus.OK);
        }
        catch (UserNotPresent e){
            throw new RuntimeException();
        }
        catch (Exception e){
            throw new RuntimeException("Error in the controller" + e.getMessage());
        }
    }

    @GetMapping("/user/{email}")
    public User findUserByEmail(@PathVariable String email){
        try {
            return this.userService.getUserByEmail(email);
        } catch (UserNotPresent e) {
            throw new RuntimeException(e);
        }
        catch (Exception e){
            throw new RuntimeException();
        }
    }

    @DeleteMapping("/user=/{email}")
    private ResponseEntity<?> deleteUser(@PathVariable String email){
        try {
           return new ResponseEntity<>( this.userService.deleteUserByEmail(email) , HttpStatus.OK);

        }
        catch (UserNotPresent u){
           throw new RuntimeException();
        }
        catch (Exception e){
            throw new RuntimeException("Exception in the controller"+ e.getMessage());
        }
    }


}
