package com.stackroute.user.authentication;

import com.stackroute.user.authentication.entity.UserAuthentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;



@SpringBootApplication()
@ComponentScan

public class UserAuthenticationApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserAuthenticationApplication.class, args);
	}

//	@Autowired
//	UserAuthenticationService userAuthenticationService;
//	@Override
//	public void run(String... args) throws Exception {
//		userAuthenticationService.addUser(new UserAuthentication("abc@gmail.com","abc"));
//		userAuthenticationService.addUser(new UserAuthentication("abcd@gmail.com","bbb"));
//			userAuthenticationService.addUser(new UserAuthentication("abcde@gmail.com","ccc"));
//
//	}

//	@Bean
//	CommandLineRunner run(UserAuthenticationService userAuthenticationService)
//	{
//		return args -> {
//		userAuthenticationService.addUser(new UserAuthentication("abc@gmail.com","abc"));
//			userAuthenticationService.addUser(new UserAuthentication("abcd@gmail.com","bbb"));
//			userAuthenticationService.addUser(new UserAuthentication("abcde@gmail.com","ccc"));
//		};
//	}

}
