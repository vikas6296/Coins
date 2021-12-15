package com.coins.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.coins.beans.Users;
import com.coins.repository.UsersData;

@Component
@Service
public class UserService {

	@Autowired
	UsersData user;
	
	public List<Users> getAllUsers()
	{
		return user.findAll();
	}
	
	
}
