package com.pivotal.services.employee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@EnableAutoConfiguration
@EnableDiscoveryClient
public class EmployeeService {
	public static void main(String args[]){
		System.setProperty("spring.config.name", "employee-service");
	
		SpringApplication.run(EmployeeService.class, args);
	}

}
