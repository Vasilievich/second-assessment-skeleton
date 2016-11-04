package com.cooksys.serviceImp;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cooksys.entity.Users;
import com.cooksys.repository.UsersRepository;
import com.cooksys.service.UsersService;

@Service
public class UsersSerivceImp implements UsersService{
	
	UsersRepository userRepo;
	
	public UsersSerivceImp (UsersRepository usersRepo) {
		this.userRepo = usersRepo;
	}
	
	public List<Users> getAll() {
		return userRepo.findByActiveTrue();
	}
	
	public Users getCreatedUser(Users user) {
		userRepo.createUsername(user.getUsername(), user.getEmail(), user.getPhone());
		return userRepo.findByUsername(user.getUsername());
	}
	
	

}
