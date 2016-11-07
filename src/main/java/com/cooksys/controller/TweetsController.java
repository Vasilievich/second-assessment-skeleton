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
		return tweetService.getAllTweets();
	}
	
	@PostMapping
	public Tweet postTweet(@RequestBody Users post) {
		return tweetService.postTweet(post);
	}
	
	@GetMapping("/{id}")
	public Tweet getIdTweet(@PathVariable Long id) {
		return tweetService.getTweetId(id);
	}
	
	@DeleteMapping("/{id}")
	public Tweet deleteIdTweet(@RequestBody Users user, @PathVariable Long id) {
		return tweetService.deleteTweetId(user, id);
	}
	
	@PostMapping("/{id}/like")
	public void postLikeTweet(@RequestBody Users user, @PathVariable Long id) {
		System.out.println(id);
		tweetService.postTweetIdLike(user, id);
	}
	
	@PostMapping("/{id}/reply")
	public Tweet postReplyTweet(@RequestBody Users user, @PathVariable Long id) {
		return tweetService.postTweetIdReply(user, id);
	}
	
	@PostMapping("/{id}/repost")
	public Tweet postRepostTweet(@RequestBody Users user, @PathVariable Long id) {
		return tweetService.postTweetIdRepost(user, id);
	}
	
	@GetMapping("/{id}/tags")
	public Hashtag getIdTweetTags(@RequestBody Hashtag tag, @PathVariable Long tweetID) {
		return null;
	}
	
//	@GetMapping("/{id}/context")
//	public Context getIdTweetContext(@PathVariable Long tweetId) {
//		return null;
//	}
	
	@GetMapping("/{id}/likes")
	public List<Users> getIdTweetLikes(@PathVariable Long id) {
		return tweetService.getTweetIdLike(id);
	}
	
	@GetMapping("/{id}/replies")
	public List<Tweet> getIdTweetReplies(@PathVariable Long id) {
		return tweetService.getTweetIdReplies(id);
	}
	
	@GetMapping("/{id}/repost")
	public List<Tweet> getIdTweetRepost(@PathVariable Long id) {
		return tweetService.getTweetIdReposts(id);
	}
	
	@GetMapping("/{id}/mentions")
	public Tweet getIdTweetMentions(@PathVariable Long tweetId) {
		return null;
	}
	
}
