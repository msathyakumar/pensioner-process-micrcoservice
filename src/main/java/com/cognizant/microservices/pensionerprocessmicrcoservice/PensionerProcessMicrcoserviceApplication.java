package com.cognizant.microservices.pensionerprocessmicrcoservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class PensionerProcessMicrcoserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PensionerProcessMicrcoserviceApplication.class, args);
	}

}
