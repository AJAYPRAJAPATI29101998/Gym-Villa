package com.stackroute.user.authentication.repository;


import com.stackroute.user.authentication.entity.UserAuthentication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAuthenticationRepository extends JpaRepository<UserAuthentication,String> {
}
