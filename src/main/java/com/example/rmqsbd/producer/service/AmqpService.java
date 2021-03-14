package com.example.rmqsbd.producer.service;

import com.example.rmqsbd.producer.data.vo.Message;

public interface AmqpService {

	public void sendToConsumer(Message message);
}
