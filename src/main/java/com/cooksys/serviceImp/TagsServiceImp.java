package com.cooksys.serviceImp;

import java.util.List;

import com.cooksys.entity.Hashtag;
import com.cooksys.entity.Tweet;
import com.cooksys.repository.TagsRepository;

public class TagsServiceImp {
	
	private TagsRepository tagRepo;
	
	public TagsServiceImp(TagsRepository tagsRepo) {
		this.tagRepo = tagsRepo;
	}
	
	public List<Hashtag> getAllTags() {
		return tagRepo.findAll();
	}
	
	public List<Tweet> getTweetTags(String tweet) {
		return null;
	}

}
