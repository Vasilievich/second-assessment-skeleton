package com.cooksys.service;

import java.util.List;

import com.cooksys.entity.Tweet;
import com.cooksys.entity.Users;

public interface UsersService {
	
	public List<Users> getAll();
	
	public boolean checkUserExist(String atUser);
	
	public Users getCreatedUser(Users user);
	
	public Users getAtUser(String atUser);
	
	public Users patchAtUser(Users updateUser, String atUser);
	
	public Users deleteAtUser(String atUser);
	
	public void postFollowUser(Users followingUser, String atUser);
	
	public void postUnfollowUser(Users unfollowingUser, String atUser);
	
	public Tweet getAtUserFeed(String atUser);
}
