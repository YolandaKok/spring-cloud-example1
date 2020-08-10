package io.yolanda.kokkinou.kafka.producers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import io.yolanda.kokkinou.dto.LogMessage;

import java.util.Date;

@Service
public class Producer {
	private static final Logger logger = LoggerFactory.getLogger(Producer.class);
	private static final String TOPIC = "logs_topic";
	
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	
	public void sendMessages(LogMessage message) {
		logger.info("Producing message: {}", message.toString());
		message.setTimestamp(new Date());
		ObjectMapper Obj = new ObjectMapper();
		for(int i = 0; i < 100; i++) {
			String jsonStr;
			try {
				jsonStr = Obj.writeValueAsString(message);
				kafkaTemplate.send(new ProducerRecord<>(TOPIC, null, jsonStr));
			} catch (JsonProcessingException e) {
				logger.error("Could not convert object to json: {}", message);
				e.printStackTrace();
			}
		}
	}
	
}
