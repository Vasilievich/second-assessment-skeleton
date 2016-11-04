package com.cooksys.service;

import java.util.List;

import com.cooksys.entity.Users;

public interface UsersService {
	
	public List<Users> getAll();
	
	public Users getCreatedUser(Users user);
}
