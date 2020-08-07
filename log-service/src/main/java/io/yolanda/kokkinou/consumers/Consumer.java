package io.yolanda.kokkinou.consumers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import io.yolanda.kokkinou.dto.LogMessage;

@Service
public class Consumer {
	
	private final Logger logger = LoggerFactory.getLogger(Consumer.class);
	
	@KafkaListener(topics = "logs_topic", groupId = "group_id")
	public void consume(String message){
		ObjectMapper Obj = new ObjectMapper();
		try {
			LogMessage logMessage = Obj.readValue(message, LogMessage.class);
			logger.info("--> Consumed Message: {}", logMessage.getMessage());
		} catch (JsonProcessingException e) {
			logger.error("Consumer could not deserialize object: {}", message);
			e.printStackTrace();
		}

	}
}