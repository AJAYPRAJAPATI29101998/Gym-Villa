package com.stackroute.feedbackreviewservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class FeedbackReviewServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(FeedbackReviewServiceApplication.class, args);
	}

}
//@ComponentScan(basePackages = {"com.stackroute.feedbackreviewservice.service.ReviewService"})