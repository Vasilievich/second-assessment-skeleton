package com.cooksys.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.cooksys.entity.Users;

public interface UsersRepository extends JpaRepository <Users, Long> {
	
	Users findByUsername(String username);
	
	List<Users> findByActiveTrue();
	
	@Transactional
	@Query(value = "insert into users0_ (username, email, timestamps) values (?1, ?2, ?3)", nativeQuery = true)
	void createUsername(String username, String email, String timestamp);
	
}
