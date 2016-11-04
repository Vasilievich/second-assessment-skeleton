package com.cooksys.service;

import java.util.List;

import com.cooksys.entity.Users;

public interface UsersService {
	
	public List<Users> getAll();
	
	public Users getCreatedUser(Users user);
	
	public Users getAtUser(String atUser);
	
	public Users patchAtUser(Users updateUser, String atUser);
	
}
