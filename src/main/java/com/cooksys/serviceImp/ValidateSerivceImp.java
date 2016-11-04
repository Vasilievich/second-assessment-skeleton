package com.cooksys.serviceImp;

import org.springframework.stereotype.Service;

import com.cooksys.entity.Hashtag;
import com.cooksys.entity.Users;
import com.cooksys.repository.TagsRepository;
import com.cooksys.repository.UsersRepository;
import com.cooksys.repository.ValidateRepository;
import com.cooksys.service.ValidateService;

@Service
public class ValidateSerivceImp implements ValidateService {

	ValidateRepository userdRepo;
	TagsRepository tagRepo;
	UsersRepository userRepo;
	
	public ValidateSerivceImp (TagsRepository tagsRepo, UsersRepository usersRepo) {
		this.tagRepo = tagsRepo;
		this.userRepo = usersRepo;
	}
	
	@Override
	public Hashtag getTagsByLabel(String label) {
		return tagRepo.findByLabel(label);
	}

	@Override
	public Users getUsersByUsername(String username) {
		return userRepo.findByUsername(username);
	}
	
	@Override
	public boolean getUsersAvailByUsername(String username) {
		if(userRepo.findByUsername(username) == null)
			return false;
		else 
			return true;
	}
}