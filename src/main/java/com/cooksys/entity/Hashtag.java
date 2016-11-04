package com.cooksys.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Hashtag {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column
	private String label;
	
	@Column
	private boolean hashtagstatus;
	
	@ManyToMany(mappedBy = "hashtag")
	private List<Tweet> tweet;
	
	public List<Tweet> getUsers() {
		return tweet;
	}

	public void setUsers(List<Tweet> users) {
		this.tweet = users;
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

	public boolean isHashtagStatus() {
		return hashtagstatus;
	}

	public void setHashtagStatus(boolean hashtagStatus) {
		hashtagstatus = hashtagStatus;
	}
}
