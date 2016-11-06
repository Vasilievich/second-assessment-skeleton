package com.cooksys.service;

import java.util.List;

import com.cooksys.entity.Tweet;

public interface TweetsService {
	
	List<Tweet> getAllTweets();
	
	Tweet getTweetId(Long tweetId);
	
	Tweet deleteTweetId(Long tweetId);
	
}
