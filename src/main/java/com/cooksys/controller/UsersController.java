package com.cooksys.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cooksys.DataTransferObject;
import com.cooksys.entity.Tweet;
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
	
	@GetMapping("/@{username}")
	public Users getAtUser(@PathVariable String username){
		return userService.getAtUser(username);
	}
	
	@PatchMapping("/@{username}")
	public Users patchAtUser(@RequestBody Users updateUser, @PathVariable String username) {
		return userService.patchAtUser(updateUser, username);
	}
	
	@DeleteMapping("/@{username}")
	public Users deleteAtUser(@PathVariable String username) {
		return userService.deleteAtUser(username);
	}
	
	@PostMapping("/@{username}/follow")
	public void followAtUser(@RequestBody Users followingUser, @PathVariable String username) {
		userService.postFollowUser(followingUser, username);
	}
	
	@PostMapping("/@{username}/unfollow")
	public void unfollowAtUser(@RequestBody Users unFollowUser, @PathVariable String username) {
		userService.postUnfollowUser(unFollowUser, username);
	}
	
	@GetMapping("/@{username}/feed")
	public List<Tweet> getFeed(@PathVariable String username) {
		return null;
	}

	@GetMapping("/@{username}/tweets")
	public Tweet getTweets(@PathVariable String username) {
		return null;
	}
	
	@GetMapping("/@{username}/mentions")
	public Tweet getMentions(@PathVariable String username) {
		return null;
	}
	
	@GetMapping("/@{username}/followers")
	public Users getFollowers(@PathVariable String username) {
		return null;
	}
	
	@GetMapping("/@{username}/following")
	public Users getFollowing(@PathVariable String username) {
		return null;
	}
}
