package com.example.rmqsbd.producer.amqp;

public interface AmqpProducer<T> {
	void producer(T t);
}
