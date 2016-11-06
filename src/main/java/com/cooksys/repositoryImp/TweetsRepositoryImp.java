package com.cooksys.repositoryImp;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.cooksys.entity.Tweet;
import com.cooksys.entity.Users;
import com.cooksys.repository.TweetsCustomRepository;

@Repository
public class TweetsRepositoryImp implements TweetsCustomRepository {
	
	EntityManager em;
	
	public TweetsRepositoryImp(EntityManager entityManager) {
		this.em = entityManager;
	}
	
	@Transactional
	public void insertTweet(Tweet tweet) {
		em.persist(tweet);
	}

	@Transactional
	public void insertTweetLike(Users user, Long tweetId) {
		System.out.println("asdf");
		em.createNativeQuery("Insert into second_assignment.tweetlike values (" + user.getId()+ "," + tweetId  + ")", Users.class).executeUpdate();
	}
	
}
