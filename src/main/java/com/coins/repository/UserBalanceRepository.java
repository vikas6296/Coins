package com.coins.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.coins.beans.UserBalance;
@Repository
public interface UserBalanceRepository extends JpaRepository<UserBalance,Integer>{}
