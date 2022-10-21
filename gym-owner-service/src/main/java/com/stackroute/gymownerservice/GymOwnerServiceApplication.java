package com.stackroute.gymownerservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class GymOwnerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(GymOwnerServiceApplication.class, args);
	}

}
