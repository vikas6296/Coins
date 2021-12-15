package com.coins.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coins.beans.Users;
import com.coins.repository.UsersData;
import com.coins.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	UsersData user;
	
	@Autowired
	UserService userServiceObject;

	

	@GetMapping(path="/service/users",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Users>> getALLUsers()
	{
		try {
			List<Users> usersFromService=userServiceObject.getAllUsers();
			return new ResponseEntity<List<Users>>(usersFromService,HttpStatus.ACCEPTED);
			
		}
		catch(Exception E)
		{
		return	new ResponseEntity<>(HttpStatus.REQUEST_TIMEOUT);
		}
		
	}
}
