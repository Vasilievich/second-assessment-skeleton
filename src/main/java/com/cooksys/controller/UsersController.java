package com.cooksys.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cooksys.DataTransferObject;
import com.cooksys.entity.Users;
import com.cooksys.service.UsersService;
import com.cooksys.service.ValidateService;

@RestController
@RequestMapping("users")
public class UsersController {
	
	UsersService userService;
	
	public UsersController(UsersService usersService) {
		this.userService = usersService;
	}
	
	@GetMapping
	public List<Users> getAll() {
		return userService.getAll();
	}
	
	@PostMapping
	public Users createUser(@RequestBody Users newUser) {
		return userService.getCreatedUser(newUser);
	}
	

}
