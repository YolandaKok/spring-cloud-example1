package io.yolanda.kokkinou.proxy;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

import io.yolanda.kokkinou.dto.UsersDTO;

@FeignClient(name="user")
@RibbonClient(name="user")
@Component
public interface UserServiceProxy {
	@GetMapping("/users")
	public UsersDTO getUsers();
}
