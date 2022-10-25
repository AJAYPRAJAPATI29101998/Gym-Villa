package com.stackroute.usersevice.service;

import com.mongodb.MongoException;
import com.stackroute.usersevice.exceptions.UserNotPresent;
import com.stackroute.usersevice.model.User;
import com.stackroute.usersevice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImplementation implements UserService{

    @Autowired
    private UserRepository userRepo;

    @Override
    public ResponseEntity<?> saveUser(User user) {
        try {
            if (userRepo.findByEmailId(user.getEmailId()) != null) {
                return new ResponseEntity<>("Email id already exist", HttpStatus.CONFLICT);
            }
            User getUser = this.userRepo.save(user);
            return new ResponseEntity<>(getUser, HttpStatus.OK);
        }
        catch (Exception m){
            return new ResponseEntity<>(m.getMessage(),HttpStatus.BAD_GATEWAY);
        }
    }

    @Override
    public User getUserByEmail(String email) throws UserNotPresent {

        Optional <User> user = Optional.ofNullable(this.userRepo.findByEmailId(email));
        if(user.isEmpty()){
            throw new UserNotPresent("User not present with emilID :- "+email);
        }
        return user.get();
    }

    @Override
    public List<User> getAllUsers() throws UserNotPresent {
       Optional <List<User>> users = Optional.of(this.userRepo.findAll());
       if(users.isEmpty() ){
           throw new UserNotPresent("No user is present");
       }
       return users.get();
    }


    @Override
    public String deleteUserByEmail(String email) throws UserNotPresent {
        Optional <User> user = Optional.ofNullable(this.userRepo.findByEmailId(email));
        if(user.isEmpty()){
            throw new UserNotPresent("User not present with emilID :- "+email);
        }
        try {
            this.userRepo.deleteById(user.get().getUserId());
            return "User removed sucessufully";
        }
        catch (Exception e){
            throw new RuntimeException();
        }
    }
}
