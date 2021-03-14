package com.example.rmqsbd.producer.service.implamentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.rmqsbd.producer.amqp.AmqpProducer;
import com.example.rmqsbd.producer.data.vo.Message;
import com.example.rmqsbd.producer.service.AmqpService;

@Service
public class RabbitMQServiceImpl implements AmqpService {

	@Autowired
	private AmqpProducer<Message> amqp;

	@Override
	public void sendToConsumer(Message message) {
		amqp.producer(message);
	}
	
}
