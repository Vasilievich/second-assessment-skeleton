package com.cooksys.serviceImp;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cooksys.entity.Hashtag;
import com.cooksys.entity.Tweet;
import com.cooksys.repository.TagsRepository;
import com.cooksys.repository.TweetsRepository;
import com.cooksys.service.TagsService;

@Service
public class TagsServiceImp implements TagsService {
	
	private TagsRepository tagRepo;
	private TweetsRepository tweetRepo;
	
	public TagsServiceImp(TagsRepository tagsRepo, TweetsRepository tweetsRepo) {
		this.tagRepo = tagsRepo;
		this.tweetRepo = tweetsRepo;
	}
	
	public List<Hashtag> getAllTags() {
		return tagRepo.findAll();
	}
	
	public List<Tweet> getTweetTags(String tweet) {
		return null;
	}
	
	
}
