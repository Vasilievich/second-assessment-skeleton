package com.cooksys.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.cooksys.entity.Users;

public interface UsersRepository extends JpaRepository <Users, Long> {
	
	//@Query(value = "Select * from Users", nativeQuery = true)
	Users findByUsername(String username);
	
	Users findByEmail(String email);
	
	List<Users> findByActiveTrue();

	@Transactional
	Users saveAndFlush(Users user);
	
}
