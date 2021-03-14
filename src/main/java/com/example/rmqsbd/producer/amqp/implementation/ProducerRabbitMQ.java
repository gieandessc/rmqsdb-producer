package com.example.rmqsbd.producer.amqp.implementation;

import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import com.example.rmqsbd.producer.amqp.AmqpProducer;
import com.example.rmqsbd.producer.data.vo.Message;

@Configuration
public class ProducerRabbitMQ implements AmqpProducer<Message> {

	@Autowired
	private RabbitTemplate RabbitTemplate;

	@Value("${spring.rabbitmq.exchange.producer}")
	private String exchange;

	@Value("${spring.rabbitmq.routing-key.producer}")
	private String queue;

	@Override
	public void producer(Message message) {
		try {
			RabbitTemplate.convertAndSend(exchange, queue, message);
		} catch (Exception e) {
			throw new AmqpRejectAndDontRequeueException(e);
		}
	}
}
