package com.cooksys.service;

import java.util.List;

import com.cooksys.entity.Hashtag;
import com.cooksys.entity.Tweet;

public interface TagsService {

	public List<Hashtag> getAllTags();
	
	public List<Tweet> getTweetTags(String tweet);
	
}
