package com.cooksys.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Hashtag {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "label")
	private String label;
	
	@Column(name = "hashtagactive")
	private boolean hashtagactive;
	
	@ManyToMany(mappedBy = "hashtag")
	@JsonIgnore
	private List<Tweet> tweet;
	
	public List<Tweet> getTweet() {
		return tweet;
	}

	public void setTweet(List<Tweet> tweets) {
		this.tweet = tweets;
	}
	
	public long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public boolean isHashtagActive() {
		return hashtagactive;
	}

	public void setHashtagActive(boolean hashtagActive) {
		hashtagactive = hashtagActive;
	}
}
