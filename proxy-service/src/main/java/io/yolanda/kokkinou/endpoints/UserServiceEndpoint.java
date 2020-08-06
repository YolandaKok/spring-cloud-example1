package io.yolanda.kokkinou.endpoints;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import io.yolanda.kokkinou.dto.UsersDTO;
import io.yolanda.kokkinou.proxy.UserServiceProxy;
import io.yolanda.kokkinou.services.UserService;

@RestController
@RequestMapping("/users")
public class UserServiceEndpoint {
	
	private static final Logger logger = LoggerFactory.getLogger(UserServiceEndpoint.class);	
	@Autowired
	private UserService service;
	
	@GetMapping("/hello")
	public String returnHello() {
		return "hello";
	}
	
	@GetMapping("/bye")
	public String returnBye() {
		return "bye";
	}
	
	@GetMapping("/test")
	@HystrixCommand(fallbackMethod = "defaultUserList")
	public UsersDTO getUsers() {
		logger.info("Getting users list.");
		return service.getUsers();
	}
	
	public UsersDTO defaultUserList() {
		String defaultUsers = "George, Mary, Oliver";
		UsersDTO response = new UsersDTO();
		response.setListOfNames(defaultUsers);
		return response;
	}
	
}
