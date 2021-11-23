package com.example.activemq.TopicPublisher.jms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;

import com.example.activemq.TopicPublisher.model.publisherModel;

@Component
public class publisherJms{
	private static final Logger logger = LoggerFactory.getLogger(publisherJms.class);
	
    @Autowired
    JmsTemplate jmsTemplate;
	
	public void send(String destination, publisherModel message) {
		jmsTemplate.convertAndSend(destination, message);
		logger.info("Message: {} published to topic: {} succesfully", message.toString(), destination);
	}
	
    
}