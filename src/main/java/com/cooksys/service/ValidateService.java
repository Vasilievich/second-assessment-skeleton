package com.cooksys.service;

import com.cooksys.entity.Hashtag;
import com.cooksys.entity.Tweet;
import com.cooksys.entity.Users;

public interface ValidateService {
	
	public Hashtag getTagsByLabel(String label);

	public Users getUsersByUsername(String username);
	
	public boolean getUsersAvailByUsername(String username1);
	
	
}
