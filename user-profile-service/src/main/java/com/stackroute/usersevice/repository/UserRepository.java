package com.stackroute.usersevice.repository;

import com.stackroute.usersevice.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User,Integer> {
    User findByEmailId(String email);
}
