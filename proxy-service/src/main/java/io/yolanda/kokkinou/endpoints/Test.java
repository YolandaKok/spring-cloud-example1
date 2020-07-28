package io.yolanda.kokkinou.endpoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.yolanda.kokkinou.config.Configuration;

@RestController
public class Test {
	
	@Autowired
	private Configuration config;
	
	@GetMapping("/test")
	public String getConfig() {
		System.out.println("Heyyyy: " + config.getMessage());
		return config.getMessage();
	}
}
