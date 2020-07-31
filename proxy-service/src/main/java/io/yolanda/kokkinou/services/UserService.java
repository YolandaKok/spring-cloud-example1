package io.yolanda.kokkinou.services;

import org.springframework.stereotype.Service;

import io.yolanda.kokkinou.dto.UsersDTO;

public interface UserService {
	UsersDTO getUsers();
}
