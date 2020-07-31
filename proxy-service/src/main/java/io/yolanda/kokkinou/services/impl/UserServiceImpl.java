package io.yolanda.kokkinou.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.yolanda.kokkinou.dto.UsersDTO;
import io.yolanda.kokkinou.proxy.UserServiceProxy;
import io.yolanda.kokkinou.services.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserServiceProxy proxy;
	
	@Override
	public UsersDTO getUsers() {
		return proxy.getUsers();
	}
	
}
