package com.cooksys.serviceImp;

import java.util.List;

import org.apache.catalina.User;
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
	

	TweetsRepository tweetRepo;
	TweetsCustomRepository tweetCustomRepo;
	UsersService userServ;
	Logger log = LoggerFactory.getLogger(TweetsServiceImp.class);
	
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
				//newTweet.setContent("shiat");
				tweetCustomRepo.insertTweet(newTweet);
				return newTweet;
			}
		}
		else
			log.info("this your credentials do not match");
		return null;
	}
	
	public Tweet getTweetId(Long tweetId) {
		if(tweetRepo.findById(tweetId)==null) {
			log.info("Tweet id {tweetId} does not exist");
			return null;
		}
		else
			return tweetRepo.findById(tweetId);
	}
	
	public Tweet deleteTweetId(Users user, Long tweetId) {
		if(userServ.checkUserExist(user.getUsername())) {
			Users targetUser = userServ.getAtUser(user.getUsername());
			if(user.getPassword().equals(targetUser.getPassword())) {
				Tweet targetTweet = getTweetId(tweetId);
				targetTweet.setTweetActive(false);
				return tweetRepo.saveAndFlush(targetTweet);
			}
			else {
				log.info("Tweet id {tweetId} does not exist", tweetId);
				return null;
			}
		}
		else {
			log.info("User don't exist");
			 return null;
		}
	}
	
	public void postTweetIdLike(Users user, Long tweetId) { //check if you already liked
		if(userServ.checkUserExist(user.getUsername())) {
			Users targetUser = userServ.getAtUser(user.getUsername());
			tweetCustomRepo.insertTweetLike(targetUser, tweetId);
		}
	}
	
	public Tweet postTweetIdReply(Users user, Long tweetId) {
		if(userServ.checkUserExist(user.getUsername()) && !(user.getContent()==null)) {
			Tweet newReplyTweet = postTweet(user);
			newReplyTweet.setTweeted(getTweetId(tweetId));
			
//			Tweet replyToTweet = getTweetId(tweetId);
			//replyToTweet.getReplies().add(newReplyTweet);
			return tweetRepo.saveAndFlush(newReplyTweet);
		}
		else {
			log.info("Your credentials are incorrect or you have no message");
			return null;
		}
	}
	
}
