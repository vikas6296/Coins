package com.coins.service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.coins.beans.UserBalance;
import com.coins.repository.UserBalanceRepository;

@Component
@Service
public class CoinsService 
{
   
	@Autowired
	UserBalanceRepository userData;
	
	public UserBalance getUserBalanceById(int id)throws Exception
	{
	  return userData.findById(id).get();	
	  
	
	}
	
	public UserBalance getUserBalanceByIdForPost(int id)throws Exception
	{
	  boolean userExist=userData.findById(id).isPresent();	
	  if(userExist==true)
		  return userData.findById(id).get();
	  else
		  return null;
	
	}
	
	public String deleteUserById(int id)
	{
		boolean userExist=userData.findById(id).isPresent();	
		  if(userExist==true)
		  {
		  userData.deleteById(id);
          return "userDeletedSuccessfully";
		  }
		  else
			  return null;
			  
	}
	
	public UserBalance creditCoins(UserBalance user)
	{
		
	  userData.save(user);
		return user;
	}

	
	public List<UserBalance> getUsersByBalance(int balance)
	{   List<UserBalance> allTheUsers = new ArrayList<UserBalance>();
		List<UserBalance> checkBalance=userData.findAll();
		for (UserBalance b:checkBalance)
		{
			if(b.getUserBalance()==balance)
				allTheUsers.add(b);
		}
		return allTheUsers;
	}
	
	public List<UserBalance> getUserBalanceByName(String name)
	{
		List<UserBalance> allTheUsers=new ArrayList<UserBalance>();
		
		List<UserBalance> checkBalance=userData.findAll();
		for(UserBalance b:checkBalance)
		{
			try {
			if(b.getName().equals(name))
			allTheUsers.add(b);
			}
			catch(Exception E){}
		}
		
		return allTheUsers;
	}
	
	
	public boolean isContainSeven(String array)
	{
		char name[]=array.toCharArray();
		
	    for(int i=0;i<name.length;i++)
	    {
	         boolean p=Pattern.matches("[7]",String.valueOf(name[i]));
	         if(p)
	        	 return true;
	    }
	    return false;
	}
	

	
}
