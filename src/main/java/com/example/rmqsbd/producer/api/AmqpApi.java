package com.example.rmqsbd.producer.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.rmqsbd.producer.data.vo.Message;
import com.example.rmqsbd.producer.service.AmqpService;

@RestController
@RequestMapping("/send")
public class AmqpApi {

	@Autowired
	private AmqpService service;

	@ResponseStatus(HttpStatus.ACCEPTED)
	@PostMapping(produces = { "application/json", "application/xml", "application/x-yaml" }, consumes = {
			"application/json", "application/xml", "application/x-yaml" })
	public void SendToConsumer(@RequestBody Message message) {
		service.sendToConsumer(message);
	}
}
