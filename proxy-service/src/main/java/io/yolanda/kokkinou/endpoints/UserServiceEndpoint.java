package io.yolanda.kokkinou.endpoints;

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
	
	@Autowired
	private UserService service;
	
	@GetMapping("/hello")
	public String returnHello() {
		return "hello";
	}
	
	@GetMapping("/test")
	@HystrixCommand(fallbackMethod = "defaultUserList")
	public UsersDTO getUsers() {
		return service.getUsers();
	}
	
	public UsersDTO defaultUserList() {
		String defaultUsers = "George, Mary, Oliver";
		UsersDTO response = new UsersDTO();
		response.setListOfNames(defaultUsers);
		return response;
	}
	
}
