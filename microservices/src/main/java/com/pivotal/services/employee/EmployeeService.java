package com.pivotal.services.employee;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Import;

import com.pivotal.employees.EmployeeRepository;
import com.pivotal.employees.EmployeesConfiguration;
import com.pivotal.utils.RabbitMqServer;
import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;

@EnableAutoConfiguration
@EnableDiscoveryClient
@Import(EmployeesConfiguration.class)
public class EmployeeService {
	@Autowired
	EmployeeRepository employeeRepository;
	
	public static void main(String args[]){
		System.setProperty("spring.config.name", "employee-service");
		SpringApplication.run(EmployeeService.class, args);
	}

}
