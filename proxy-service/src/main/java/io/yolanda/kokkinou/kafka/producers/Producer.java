package io.yolanda.kokkinou.kafka.producers;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import io.yolanda.kokkinou.dto.LogMessage;

@Service
public class Producer {
	private static final Logger logger = LoggerFactory.getLogger(Producer.class);
	private static final String TOPIC = "logs_topic";
	
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	
	public void sendMessages(LogMessage message) {
		logger.info("Producing message: {}", message.toString());
		kafkaTemplate.send(new ProducerRecord<>(TOPIC, null, message.toString()));
	}
	
}
