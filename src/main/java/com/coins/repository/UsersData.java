package com.coins.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coins.beans.Users;

public interface UsersData extends JpaRepository<Users,Integer>{}
