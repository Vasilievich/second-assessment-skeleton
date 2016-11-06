package com.cooksys.repositoryImp;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import com.cooksys.entity.Tweet;
import com.cooksys.repository.TweetsCustomRepository;

@Repository
public class TweetsRepositoryImp implements TweetsCustomRepository {
	
	EntityManager em;
	
	public TweetsRepositoryImp(EntityManager entityManager) {
		this.em = entityManager;
	}
	
	public void insertTweet(Tweet tweet) {
		em.persist(tweet);
	}
	
}
