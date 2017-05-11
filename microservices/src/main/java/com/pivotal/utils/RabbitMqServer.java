package com.pivotal.utils;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;

public class RabbitMqServer {
	private String QUEUE_NAME = "rabbit-queue";
	private ConnectionFactory factory;
	private Connection connection;
	private Channel channel;

	public RabbitMqServer() {
		factory = new ConnectionFactory();
		factory.setHost("localhost");
		try {
			connection = factory.newConnection();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		} catch (TimeoutException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}
		try {
			channel = connection.createChannel();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}
		try {
			channel.queueDeclare(QUEUE_NAME, false, false, false, null);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}
	}

	public void recvMessage() {
		Consumer consumer = new DefaultConsumer(channel) {
			@Override
			public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties,
					byte[] body) throws IOException {
				String message = new String(body, "UTF-8");
				System.out.println(" [x] Received '" + message + "'");
			}
		};
		try {
			channel.basicConsume(QUEUE_NAME, true, consumer);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
