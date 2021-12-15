package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.coins.beans.UserBalance;
import com.coins.repository.UserBalanceRepository;
import com.coins.service.CoinsService;

@SpringBootTest(classes= {CoinsApplicationTests.class})
class CoinsApplicationTests {

@Mock
UserBalanceRepository userBalanceRepo;

@InjectMocks
CoinsService coinsService;

public List<UserBalance> users;

@Test
@Order(1)
public void getUserBalanceTest() throws Exception
{
	 users=new ArrayList<UserBalance>();
	users.add(new UserBalance(1,2000,"vikas"));
	users.add(new UserBalance(2,2000,"divsyy"));
	
	
	
	
	when(userBalanceRepo.getById(2).getUserBalance()).thenReturn(users.get(1).getUserBalance());
	
	assertEquals(2000, coinsService.getUserBalanceById(2));
	
	
	
	
	
	
}


	
}
