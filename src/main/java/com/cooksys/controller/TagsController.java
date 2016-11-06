package com.cooksys.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cooksys.entity.Hashtag;
import com.cooksys.entity.Tweet;
import com.cooksys.service.TagsService;

@RestController
@RequestMapping("tags")
public class TagsController {
	
	TagsService tagService;
	
	public TagsController(TagsService tagsService) {
		this.tagService = tagsService;
	}
	
	@GetMapping
	public List<Hashtag> getAll() {
		return tagService.getAllTags();
	}
	
	@GetMapping("/{label}")
	public List<Tweet> getTweetTags (@PathVariable String tweet) {
		return tagService.getTweetTags(tweet);
	}
}
