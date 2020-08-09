package io.yolanda.kokkinou.consumers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.yolanda.kokkinou.repositories.LogRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Service;

import io.yolanda.kokkinou.dto.LogMessage;

@Service
public class Consumer {

	@Autowired
	private LogRepository elasticRepository;

	private final Logger logger = LoggerFactory.getLogger(Consumer.class);
	
	@KafkaListener(topics = "logs_topic", groupId = "group_id")
	public void consume(String message, @Header(KafkaHeaders.RECEIVED_TOPIC) String topic,
						@Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition,
						@Header(KafkaHeaders.OFFSET) String offset) {
		logger.info("Partition: {} Offset {} Topic {}", partition, offset, topic);
		ObjectMapper Obj = new ObjectMapper();
		try {
			LogMessage logMessage = Obj.readValue(message, LogMessage.class);
			logger.info("--> Consumed Message: {}", logMessage.getMessage());
			LogMessage result = elasticRepository.save(logMessage);
			logger.info("Index id: {}", result.getId());
		} catch (JsonProcessingException e) {
			logger.error("Consumer could not deserialize object: {}", message);
			e.printStackTrace();
		}

	}
}