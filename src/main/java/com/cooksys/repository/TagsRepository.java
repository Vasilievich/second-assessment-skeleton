package com.cooksys.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cooksys.entity.Hashtag;

public interface TagsRepository extends JpaRepository <Hashtag, Long>{
	
	Hashtag findByLabel(String label);
	
	List<Hashtag> findAll();
}
