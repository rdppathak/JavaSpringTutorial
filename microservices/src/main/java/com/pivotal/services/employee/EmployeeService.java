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
import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;

class RabbitQueueServer implements Runnable{
	private Thread t;
	private String threadName;
	private String QUEUE_NAME = "rabbit-queue";
	protected ConnectionFactory factory;
	public RabbitQueueServer(String threadName) {
		this.threadName = threadName;
	}
	
	public void start(){
		System.out.println("Starting rabbitQ server thread");
		t = new  Thread(this, threadName);
		t.start();
	}
	
	@Override
	public void run() {
		factory = new ConnectionFactory();
		factory.setHost("localhost");
		Connection connection =null;
		try {
			connection = factory.newConnection();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TimeoutException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}
		Channel channel = null;
		try {
			channel = connection.createChannel();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			channel.queueDeclare(QUEUE_NAME, false, false, false, null);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Consumer consumer = new DefaultConsumer(channel) {
			  @Override
			  public void handleDelivery(String consumerTag, Envelope envelope,
			                             AMQP.BasicProperties properties, byte[] body)
			      throws IOException {
			    String message = new String(body, "UTF-8");
			    System.out.println(" [x] Received '" + message + "'");
			  }
			};
		try {
			System.out.println("RabbitQ server started successfully");
			channel.basicConsume(QUEUE_NAME, true, consumer);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}

@EnableAutoConfiguration
@EnableDiscoveryClient
@Import(EmployeesConfiguration.class)
public class EmployeeService {
	@Autowired
	EmployeeRepository employeeRepository;
	public static void main(String args[]){
		System.setProperty("spring.config.name", "employee-service");
		RabbitQueueServer rbs = new RabbitQueueServer("rabbit-server");
		rbs.start();
		SpringApplication.run(EmployeeService.class, args);
	}

}
