package io.yolanda.kokkinou.endpoints;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.yolanda.kokkinou.dto.LogMessage;
import io.yolanda.kokkinou.kafka.producers.Producer;

@RestController
@RequestMapping("/log")
public class LogsEndpoint {
	
	private static final Logger logger = LoggerFactory.getLogger(LogsEndpoint.class);
	
	@Autowired
	private Producer producer;
	
	@PostMapping("/post")
	public void createLog(@RequestBody LogMessage message) {
		logger.info("Message: {}", message);
		producer.sendMessages(message);
	}
		
}
