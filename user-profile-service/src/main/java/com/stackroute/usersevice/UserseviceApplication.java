package com.stackroute.usersevice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class UserseviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserseviceApplication.class, args);
	}

}
