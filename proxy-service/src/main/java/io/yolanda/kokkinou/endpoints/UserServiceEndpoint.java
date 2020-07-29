package io.yolanda.kokkinou.endpoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.yolanda.kokkinou.dto.UsersDTO;
import io.yolanda.kokkinou.proxy.UserServiceProxy;

@RestController
@RequestMapping("/users")
public class UserServiceEndpoint {
	
	@Autowired
	private UserServiceProxy proxy;
	
	@GetMapping("/hello")
	public String returnHello() {
		return "hello";
	}
	
	@GetMapping("/test")
	public UsersDTO getUsers() {
		return proxy.getUsers();
	}
}
