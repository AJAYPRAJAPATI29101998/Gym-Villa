package com.stackroute.paymentservice;

//import com.stackroute.paymentservice.entity.Order;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.scheduling.annotation.Scheduled;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;



//@EnableSwagger2
@SpringBootApplication
@EnableEurekaClient
public class PaymentServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PaymentServiceApplication.class, args);
	}

}
