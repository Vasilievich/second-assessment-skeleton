package com.cooksys.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cooksys.entity.Hashtag;
import com.cooksys.entity.Tweet;
import com.cooksys.entity.Users;
import com.cooksys.service.TweetsService;

@RestController
@RequestMapping("tweet")
public class TweetsController {
	
	TweetsService tweetService;
	
	public TweetsController(TweetsService tweetsService) {
		this.tweetService = tweetsService;
	}
	
	@GetMapping
	public List<Tweet> getAllTweets() {
		return null;
	}
	
	@PostMapping
	public Tweet postTweet(@RequestBody Users post) {
		return null;
	}
	
	@GetMapping("/{id}")
	public Tweet getIdTweet(@PathVariable Long tweetId) {
		return null;
	}
	
	@DeleteMapping("/{id}")
	public Tweet deleteIdTweet(@RequestBody Users user, @PathVariable Long tweetId) {
		return null;
	}
	
	@PostMapping("/{id}/like")
	public void postLikeTweet(@RequestBody Users user, @PathVariable Long tweetId) {
		
	}
	
	@PostMapping("/{id}/reply")
	public Tweet postReplyTweet(@RequestBody Users user, @PathVariable Long tweetId) {
		return null;
	}
	
	@PostMapping("/{id}/repost")
	public Tweet postRepostTweet(@RequestBody Users user, @PathVariable Long tweetId) {
		return null;
	}
	
	@GetMapping("/{id}/tags")
	public Hashtag getIdTweetTags(@RequestBody Hashtag tag, @PathVariable Long tweetID) {
		return null;
	}
	
//	@GetMapping("/{id}/context")
//	public Context getIdTweetContext(@PathVariable Long tweetId) {
//		return null;
//	}
	
	@GetMapping("/{id}/replies")
	public Tweet getIdTweetReplies(@PathVariable Long tweetId) {
		return null;
	}
	
	@GetMapping("/{id}/repost")
	public Tweet getIdTweetRepost(@PathVariable Long tweetId) {
		return null;
	}
	
	@GetMapping("/{id}/mentions")
	public Tweet getIdTweetMentions(@PathVariable Long tweetId) {
		return null;
	}
	
}
