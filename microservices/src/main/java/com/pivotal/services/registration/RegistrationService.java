package com.pivotal.services.registration;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

import com.pivotal.utils.RabbitMqClient;

@SpringBootApplication
@EnableEurekaServer
public class RegistrationService {
	
	public static void main(String[] args) throws IOException, TimeoutException {
		System.out.println("Initialiaing Microserver registration server");
		System.setProperty("spring.config.name", "registration-service");
		SpringApplication.run(RegistrationService.class, args);
	}
}
