//package com.stackroute.user.authentication.service;
//
//import com.stackroute.user.authentication.entity.UserAuthentication;
//import com.stackroute.user.authentication.repository.UserAuthenticationRepository;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import javax.transaction.Transactional;
//import java.util.List;
//import java.util.Optional;
//
//@Service@Transactional
//@Slf4j
//public class UserAuthenticationService_Impl implements UserAuthenticationService {
//    @Autowired
//    UserAuthenticationRepository repo;
//
//    @Override
//    public UserAuthentication addUser(UserAuthentication user) {
//        log.info("adding the new email{} into the Database", user.getEmailId());
//        return repo.save(user);
//
//    }
//
//    @Override
//    public Optional<UserAuthentication> getUser(String email) {
//        return repo.findById(email);
//    }
//
//    @Override
//    public List<UserAuthentication> getAllUsers() {
//        log.info("getting the users from the database");
//        return repo.findAll();
//    }
//
//    @Override
//    public String loginuser(UserAuthentication user) throws RuntimeException
//    {
//        UserAuthentication existingUser = repo.findById(user.getEmailId()).orElse(null);
//        try {
//            if (existingUser.getPassword().equals(user.getPassword()))
//            {
//                return "emailid and password is correct";
//            }
//        } catch (Exception e1)
//        {
//            throw new RuntimeException("email Id and password is not correct");
//
//        }
//        return "not authorizesd";
//    }
//
//
//
//
//
//}
