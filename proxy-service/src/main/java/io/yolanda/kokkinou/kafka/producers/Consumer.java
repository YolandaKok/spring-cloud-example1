package io.yolanda.kokkinou.kafka.producers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import io.yolanda.kokkinou.dto.LogMessage;

@Service
public class Consumer {
	
	private final Logger logger = LoggerFactory.getLogger(Consumer.class);
	
	@KafkaListener(topics = "logs_topic", groupId = "group_id")
	public void consume(LogMessage message){
		logger.info("--> Consumed Message: {}", message);
	}
}