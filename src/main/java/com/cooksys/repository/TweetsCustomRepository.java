package com.cooksys.repository;

import com.cooksys.entity.Tweet;
import com.cooksys.entity.Users;

public interface TweetsCustomRepository {
	
	void insertTweet(Tweet tweet);
	
	void insertTweetLike(Users user, Long tweetId);

}
