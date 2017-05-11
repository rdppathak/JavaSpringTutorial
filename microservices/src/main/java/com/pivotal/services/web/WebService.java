package com.pivotal.services.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableDiscoveryClient
@EnableWebMvc
@EnableFeignClients
//@ComponentScan(basePackageClasses = EmployeesServiceFeignClient.class)
public class WebService {
	public static void main(String[] args) {
		System.out.println("Initializing Web Service");
		System.setProperty("spring.config.name", "web-service");
		SpringApplication.run(WebService.class, args);
	}

}
