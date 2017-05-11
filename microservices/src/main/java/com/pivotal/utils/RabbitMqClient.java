package com.pivotal.utils;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class RabbitMqClient{
	private ConnectionFactory factory;
	private Connection connection;
	private Channel channel;
	private String QUEUE_NAME = "rabbit-queue";
	
	public RabbitMqClient() throws IOException, TimeoutException{
		factory = new ConnectionFactory();
		factory.setHost("localhost");
		connection = factory.newConnection();
		channel = connection.createChannel();
	}

	public void sendMessage(Object object) {
		byte[] msg = null;
		try {
			channel.queueDeclare(QUEUE_NAME, false, false, false, null);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			msg = object.toString().getBytes();
			channel.basicPublish("", QUEUE_NAME, null, msg);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(" [x] Sent '" + msg + "'");
		
	}
}
