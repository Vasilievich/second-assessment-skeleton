package com.cooksys.repository;

import com.cooksys.entity.Users;

public interface UsersCustomRepository {
	
	void insertUser(Users newUser);

	void updateUserFollowing(Long id, Long id2);
	
	void updateUserUnfollowing(Long id, Long id2);
}
