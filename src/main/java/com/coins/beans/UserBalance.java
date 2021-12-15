package com.coins.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
 
@Entity
@Table(name="coins")
public class UserBalance {

	
	@Id
	@Column(name="id")
	private int id;
	
	

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserBalance() {
		return userBalance;
	}
	public void setUserBalance(int userBalance) {
		this.userBalance = userBalance;
	}
	@Column(name="userBalance")
	private int userBalance;
	
	public UserBalance(int id,int userBalance)
	{
		this.id=id;
		this.userBalance=userBalance;
	}
	
	@Column(name="name")
	private String name;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	@Column(name="array")
	private String array;
	
	
	
	public String getArray() {
		return array;
	}
	public void setArray(String array) {
		this.array = array;
	}
	public UserBalance(int i, int j, String string){
		
	}
	
public UserBalance() {}
	
	
}
