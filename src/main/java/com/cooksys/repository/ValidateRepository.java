package com.cooksys.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cooksys.entity.Hashtag;
import com.cooksys.entity.Tweet;
import com.cooksys.entity.Users;

public interface ValidateRepository extends JpaRepository<Tweet, Long> {
	
	//Tweet findByLabel(String label);
	
//	Users findByUsername(String username);
	
}
