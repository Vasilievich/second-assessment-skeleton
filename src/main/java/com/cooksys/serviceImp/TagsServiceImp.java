package com.cooksys.serviceImp;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cooksys.entity.Hashtag;
import com.cooksys.entity.Tweet;
import com.cooksys.repository.TagsRepository;
import com.cooksys.service.TagsService;

@Service
public class TagsServiceImp implements TagsService {
	
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
