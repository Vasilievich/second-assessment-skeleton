package com.cooksys.serviceImp;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.cooksys.entity.Tweet;
import com.cooksys.entity.Users;
import com.cooksys.repository.TweetsCustomRepository;
import com.cooksys.repository.TweetsRepository;
import com.cooksys.service.TweetsService;
import com.cooksys.service.UsersService;

@Service
public class TweetsServiceImp implements TweetsService {
	
	Logger log = LoggerFactory.getLogger(TweetsServiceImp.class);
	TweetsRepository tweetRepo;
	TweetsCustomRepository tweetCustomRepo;
	UsersService userServ;
	
	public TweetsServiceImp(TweetsRepository tweetsRepo, TweetsCustomRepository tweetsCustomRepo, UsersService usersServ) {
		this.tweetRepo = tweetsRepo;
		this.tweetCustomRepo = tweetsCustomRepo;
		this.userServ = usersServ;
	}
//	public boolean checkUserExist(Long tweetId) {
//		if(getTweetId(tweetId)==null)
//				return false;
//		else
//			return true;
//	}
	
	public List<Tweet> getAllTweets() {
		return tweetRepo.findByActiveTrue();
	}
	
	public Tweet postTweet(Users post) {
		if(userServ.checkUserExist(post.getUsername())) {
			Users targetUser = userServ.getAtUser(post.getUsername());
			if(post.getPassword().equals(targetUser.getPassword())) {
				Tweet newTweet = new Tweet(post.getUsername(), post.getContent());
				tweetCustomRepo.insertTweet(newTweet);
				return newTweet;
			}
		}
		else
			log.info("this your credentials do not match");
		return null;
	}
	
	public Tweet getTweetId(Long tweetId) {
		if(tweetRepo.findById()==null) {
			log.info("Tweet id {tweetId} does not exist");
			return null;
		}
		else
			return tweetRepo.findById();
	}
	
	public Tweet deleteTweetId(Long tweetId) {
		Tweet targetTweet = getTweetId(tweetId);
		targetTweet.setTweetActive(false);
		return tweetRepo.saveAndFlush(targetTweet);
	}
	
	
}
