package com.cooksys.repositoryImp;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.cooksys.entity.Users;
import com.cooksys.repository.UsersCustomRepository;
import com.cooksys.repository.UsersRepository;

@Repository
public class UsersRepositoryImp implements UsersCustomRepository{
	
	EntityManager entityManager;
	
	public UsersRepositoryImp(EntityManager em) {
		entityManager = em;
	}
	
	@Transactional
	public void insertUser(Users newUser) {
		entityManager.persist(newUser);
	}
	
	@Transactional
	public void updateUserFollowing(Long followingUser, Long targetUser) {					//this user is following this user
		entityManager.createNativeQuery("Insert into second_assignment.followings values (" + followingUser + "," + targetUser + ")", Users.class).executeUpdate();
																							//this user is followed by this user
		entityManager.createNativeQuery("Insert into second_assignment.followers values (" + targetUser + "," + followingUser + ")", Users.class).executeUpdate();
	}
	
	@Transactional
	public void updateUserUnfollowing(Long followingUser, Long targetUser) {					//this user is following this user
		entityManager.createNativeQuery("Delete from second_assignment.followings where followings.following = " + followingUser + " and followings.users =" + targetUser, Users.class).executeUpdate();
																							//this user is followed by this user
		entityManager.createNativeQuery("Delete from second_assignment.followers where followers.follower = " + targetUser + " and followers.users =" + followingUser, Users.class).executeUpdate();
		}
}
