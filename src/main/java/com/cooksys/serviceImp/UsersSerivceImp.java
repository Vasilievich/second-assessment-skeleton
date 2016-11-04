package com.cooksys.serviceImp;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.cooksys.entity.Users;
import com.cooksys.repository.UsersCustomRepository;
import com.cooksys.repository.UsersRepository;
import com.cooksys.service.UsersService;
import com.cooksys.service.ValidateService;

@Service
public class UsersSerivceImp implements UsersService{
	

	UsersRepository userRepo;
	UsersCustomRepository userCustomRepo;

	Logger log = LoggerFactory.getLogger(UsersSerivceImp.class);
	
	
	public UsersSerivceImp (UsersRepository usersRepo, 	UsersCustomRepository usersCustomRepo) {
		this.userRepo = usersRepo;
		this.userCustomRepo = usersCustomRepo;
	}
	
	public boolean checkUserExist(String username) {
		if(getAtUser(username)==null)
				return false;
		else
			return true;
	}
	public boolean checkUserAvailable(String username) {
		return getAtUser(username).isActive();
	}
	
	public List<Users> getAll() {
		return userRepo.findByActiveTrue();
	}
	
	public Users getCreatedUser(Users user) {
		if(user.getUsername() == null || user.getEmail() == null) {
			log.info("One or more required fields are missing");
			return null;
		}
		else if(!(userRepo.findByEmail(user.getEmail())==null)) {
			log.info("Email is already in used");
			return null;
		}
		else if(!(userRepo.findByUsername(user.getUsername())==null))
		{
			if(!userRepo.findByUsername(user.getUsername()).isActive()) {
				Users deletedUser = userRepo.findByUsername(user.getUsername());
				deletedUser.setActive(!deletedUser.isActive());
				log.info("Deleted user {username} has be reactivated", user.getUsername());
				return userRepo.saveAndFlush(deletedUser);
			}
			else
				log.info("User {username} already exists", user.getUsername());
			return null;
		}
		userCustomRepo.insertUser(user);
		return userRepo.findByUsername(user.getUsername());
	}
	
	public Users getAtUser(String atUser) {
		return userRepo.findByUsername(atUser.substring(0));
	}
	
	public Users patchAtUser(Users updateUser, String atUser) {	 //robost the email duplicates
		if(checkUserExist(atUser)) {
			log.info("User {username} does not exist", atUser.substring(0));
			return null;
		}
		Users oldUser = getAtUser(atUser);
		if(oldUser.getUsername().equals(updateUser.getUsername()) && oldUser.getPassword().equals(updateUser.getPassword())) {
			if(!(updateUser.getEmail()==null))
				oldUser.setEmail(updateUser.getEmail());
			if(!(updateUser.getFirstname()==null))
				oldUser.setFirstname(updateUser.getFirstname());
			if(!(updateUser.getLastname()==null))
				oldUser.setLastname(updateUser.getLastname());
			if(!(updateUser.getPhone()==null))
				oldUser.setPhone(updateUser.getPhone());
			if(!(updateUser.getPassword()==null))
				oldUser.setPassword(updateUser.getPassword());
			return userRepo.saveAndFlush(oldUser);
		}
		else
			log.info("The username or password was incorrect");
		return null;
	}
	
	public Users deleteAtUser(String atUser) {
		if(checkUserExist(atUser)) {
			Users currentUser = getAtUser(atUser);
			currentUser.setActive(false);
			return userRepo.saveAndFlush(currentUser);
		}
		return null;
	}
	
	
	
	

}
