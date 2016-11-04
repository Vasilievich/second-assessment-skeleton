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
//	EntityTransaction entityTransaction;

	
	public UsersRepositoryImp(EntityManager em) {
		entityManager = em;
	//	entityTransaction = em.getTransaction();
	}
	
	@Transactional
	public void insertUser(Users newUser) {
		entityManager.persist(newUser);
	}
	
}
