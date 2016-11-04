package com.cooksys.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cooksys.entity.Hashtag;
import com.cooksys.service.ValidateService;

@RestController
@RequestMapping("validate")
public class ValidateController {
	
	ValidateService validateService;
	
	public ValidateController(ValidateService validService) {
		this.validateService = validService;
	}
	
	@GetMapping("/tag/exists/{label}")
	public boolean isTag(@PathVariable String label) {
		return validateService.getTagsByLabel(label).isHashtagActive();
	}
	
	@GetMapping("/username/exist/@{username}")
	public boolean isExistUser(@PathVariable String username) {
		return !validateService.getUsersByUsername(username).isActive();
	}
	
	@GetMapping("/username/available/@{username}")
	public boolean isAvailUser(@PathVariable String username) {
		return !validateService.getUsersAvailByUsername(username);
	}

}
