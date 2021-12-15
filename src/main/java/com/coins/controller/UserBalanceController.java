package com.coins.controller;


import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.coins.beans.UserBalance;
import com.coins.repository.UserBalanceRepository;
import com.coins.service.CoinsService;

@RestController

public class UserBalanceController 
{
	
	private static Log logger = LogFactory.getLog(UserBalanceController.class);
   
	@Autowired
   CoinsService coinsService;
		
	@Autowired
	UserBalanceRepository userRepos;
	
	@GetMapping(path="/service/coins/{userId}",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserBalance> getBalanceById(@PathVariable(value="userId") int id)
	{
		try {
		
			UserBalance user= coinsService.getUserBalanceById(id);
			logger.debug("request sucessful");
			return new ResponseEntity<UserBalance>(user,HttpStatus.OK);
		}
		catch(Exception E) {
			logger.debug("request failed");
			return new ResponseEntity<>(HttpStatus.REQUEST_TIMEOUT);
		}
	}
	
	@PutMapping(path="/service/coins/updateBalance/{userId}",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserBalance> updateUserBalance(@PathVariable(value="userId") int id,@RequestBody UserBalance userData)
	{
		try {
		UserBalance userId=coinsService.getUserBalanceById(id);
		int getBalanceOfUser=userId.getUserBalance();
		if(getBalanceOfUser==0)
			
			userId.setUserBalance(userData.getUserBalance()+50);
	else 
		userId.setUserBalance(userData.getUserBalance());
		UserBalance updatedBalance=coinsService.creditCoins(userId);
		return new ResponseEntity<UserBalance>(updatedBalance,HttpStatus.OK);
		}
		catch(Exception E)
		{
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}	
		

	}
	
	

	@PostMapping(path="/service/coins/updateNewUserBalance/{userId}",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserBalance> updateNewUserBalance(@PathVariable(value="userId") int id,@RequestBody UserBalance userData)
	{
		UserBalance updatedBalance=null;
		try {
			UserBalance userId=coinsService.getUserBalanceByIdForPost(id);
		
		if(String.valueOf(userId)==null)
		{
			userData.setId(id);
			userData.setUserBalance(50);
			updatedBalance=coinsService.creditCoins(userData);
		}
			else 
				
				{
				
				userData.setId(id);
				userData.setUserBalance(userData.getUserBalance());
		 updatedBalance=coinsService.creditCoins(userData);
				
				}
		
		return new ResponseEntity<UserBalance>(updatedBalance,HttpStatus.OK);
		
		}
		
		catch(Exception E)
		
		{
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}	
		

	}
	
	
	@DeleteMapping(path="/service/coins/deleteUserByID/{userId}",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> deleteUserById(@PathVariable(value="userId") int id)
	{
		try {
			String userDeleted=coinsService.deleteUserById(id);
		
		if(userDeleted==null)
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			else 
				return new ResponseEntity<String>(userDeleted,HttpStatus.OK);
		
		}
		catch(Exception E)
		
		{
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}	
		
	}
	
	@GetMapping(path="/employees",produces=MediaType.APPLICATION_JSON_VALUE)
	  List<UserBalance> all() {
	    return userRepos.findAll();
	  }
	
	@GetMapping(path="/service/coins",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<UserBalance>> getUserByParticularBalance(@RequestParam(value="balance") int balanced)
	{
		try {
		List<UserBalance> allTheUserFromService=coinsService.getUsersByBalance(balanced);
		if(balanced==0)
			return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
		else
			return new ResponseEntity<List<UserBalance>>(allTheUserFromService,HttpStatus.OK);
		}
		catch(Exception E)
		{
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
		
	}
	
	@GetMapping(path="/service/coins/get",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<UserBalance>> getUserBalanceByName(@RequestParam String name)
	{
		try {
			List<UserBalance> alltheUserFromNameService=coinsService.getUserBalanceByName(name);
			if(alltheUserFromNameService.isEmpty())
				return new ResponseEntity<>(HttpStatus.CONFLICT);
			else
				return new ResponseEntity<List<UserBalance>>(alltheUserFromNameService,HttpStatus.OK);
		}
		catch(Exception E)
		{
			System.out.println(E.getMessage());
			E.printStackTrace();
			
			return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
		}
	}
	
	
	@PostMapping(path="/service/coins/checkContainsSeven",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> checkArrayContainsSeven(@RequestBody UserBalance userData)
	{
		try {
			boolean checkService=coinsService.isContainSeven(userData.getArray());
		
	        if(checkService)
	        {    int id=userData.getId();
	             userData.setId(id);
	        	coinsService.creditCoins(userData);
		     return new ResponseEntity<String>("Array contains 7 in it",HttpStatus.OK);
	        }
		
	        else
	        {
	        	 int id=userData.getId();
	             userData.setId(id);
	             coinsService.creditCoins(userData);
	        	return new ResponseEntity<String>("Array not contains 7 in it",HttpStatus.OK);
	        	
	        }
		}
		
		catch(Exception E)
		
		{
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}	
		

	}
	
	
	
}
