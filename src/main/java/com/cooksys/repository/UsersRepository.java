package com.cooksys.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cooksys.entity.Users;

public interface UsersRepository extends JpaRepository <Users, Long> {
	
	Users findByUsername(String username);
	
	void createUsername(Users user);
	
}
