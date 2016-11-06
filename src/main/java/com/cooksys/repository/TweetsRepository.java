package com.cooksys.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.cooksys.entity.Tweet;
import com.cooksys.entity.Users;

public interface TweetsRepository extends JpaRepository<Tweet, Long>{
	
	List<Tweet> findByActiveTrue();
	
	Tweet findById();

	@Transactional
	Tweet saveAndFlush(Tweet tweet);
	
}
