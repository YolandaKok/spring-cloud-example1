package io.yolanda.kokkinou.consumers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.yolanda.kokkinou.repositories.LogRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Service;

import io.yolanda.kokkinou.dto.LogMessage;

import java.util.List;

@Service
public class Consumer {

	@Autowired
	private LogRepository elasticRepository;

	private final Logger logger = LoggerFactory.getLogger(Consumer.class);

	@KafkaListener(topics = "logs_topic", groupId = "group_id")
	public void consume1(List<String> messages,
						@Header(KafkaHeaders.RECEIVED_TOPIC) List<String> topics,
						@Header(KafkaHeaders.RECEIVED_PARTITION_ID) List<Integer> partitions,
						@Header(KafkaHeaders.OFFSET) List<Long> offsets, Acknowledgment ack) {
		logger.info("Thread: " + Thread.currentThread().getId() + " Consumer 1");
		logger.info("Messages: {}", messages.size());
		for(int i = 0; i < messages.size(); i++) {
			logger.info("Message: {}", messages.get(i));
			sinkIntoElasticSearch(messages.get(i), partitions.get(i) + "" + offsets.get(i) + "" + topics.get(i));
		}
		ack.acknowledge();
	}


	@KafkaListener(topics = "logs_topic", groupId = "group_id")
	public void consume2(List<String> messages,
						 @Header(KafkaHeaders.RECEIVED_TOPIC) List<String> topics,
						 @Header(KafkaHeaders.RECEIVED_PARTITION_ID) List<Integer> partitions,
						 @Header(KafkaHeaders.OFFSET) List<Long> offsets, Acknowledgment ack) {
		logger.info("Thread: " + Thread.currentThread().getId() + " Consumer 2");
		logger.info("Messages: {}", messages.size());
		for(int i = 0; i < messages.size(); i++) {
			logger.info("Message: {}", messages.get(i));
			sinkIntoElasticSearch(messages.get(i), partitions.get(i) + "" + offsets.get(i) + "" + topics.get(i));
		}
		ack.acknowledge();
	}

	@KafkaListener(topics = "logs_topic", groupId = "group_id")
	public void consume3(List<String> messages,
						 @Header(KafkaHeaders.RECEIVED_TOPIC) List<String> topics,
						 @Header(KafkaHeaders.RECEIVED_PARTITION_ID) List<Integer> partitions,
						 @Header(KafkaHeaders.OFFSET) List<Long> offsets, Acknowledgment ack) {
		logger.info("Thread: " + Thread.currentThread().getId() + " Consumer 3");
		logger.info("Messages: {}", messages.size());
		for(int i = 0; i < messages.size(); i++) {
			logger.info("Message: {}", messages.get(i));
			sinkIntoElasticSearch(messages.get(i), partitions.get(i) + "" + offsets.get(i) + "" + topics.get(i));
		}
		ack.acknowledge();
	}

	public void sinkIntoElasticSearch(String message, String id) {
		ObjectMapper Obj = new ObjectMapper();
		try {
			LogMessage logMessage = Obj.readValue(message, LogMessage.class);
			logger.info("--> Consumed Message: {}", logMessage.getMessage());
			logMessage.setId(id);
			LogMessage result = elasticRepository.save(logMessage);
			logger.info("Index id: {}", result.getId());
		} catch (JsonProcessingException e) {
			logger.error("Consumer could not deserialize object: {}", message);
			e.printStackTrace();
		}
	}

}