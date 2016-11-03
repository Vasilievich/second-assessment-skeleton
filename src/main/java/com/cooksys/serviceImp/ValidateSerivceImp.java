package com.cooksys.serviceImp;

import org.springframework.stereotype.Service;

import com.cooksys.entity.Hashtag;
import com.cooksys.entity.Tweet;
import com.cooksys.entity.Users;
import com.cooksys.repository.ValidateRepository;
import com.cooksys.service.ValidateService;

@Service
public class ValidateSerivceImp implements ValidateService {

	ValidateRepository validRepo;
	
	public ValidateSerivceImp (ValidateRepository validRepo) {
		this.validRepo = validRepo;
	}
	
	@Override
	public Tweet getTagsByLabel(String label) {
		return validRepo.findByLabel(label);
	}

//	@Override
//	public Users getUsersByUsername(String username) {
//		return validRepo.findByUsername(username);
//	}
//	
//	@Override
//	public boolean getUsersAvailByUsername(String username1) {
//		if(validRepo.findByUsername(username1) == null)
//			return true;
//		else 
//			return false;
//	}
}