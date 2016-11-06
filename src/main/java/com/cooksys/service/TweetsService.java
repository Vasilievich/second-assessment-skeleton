package com.cooksys.service;

import java.util.List;

import com.cooksys.entity.Tweet;
import com.cooksys.entity.Users;

public interface TweetsService {
	
	List<Tweet> getAllTweets();
	
	Tweet getTweetId(Long tweetId);
	
	Tweet postTweet(Users post);
	
	Tweet deleteTweetId(Users user,Long tweetId);
	
	void postTweetIdLike(Users user, Long tweetId);
}
