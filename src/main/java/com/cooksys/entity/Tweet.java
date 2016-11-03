package com.cooksys.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import java.util.List;

@Entity
public class Tweet {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column
	private String author;
	
	@Column
	private String posted;
	
	@Column
	private String context;
	
//	@Column
//	private Tweet inrepyof;
//	
//	@Column
//	private Tweet repostof;
	
	@Column
	private boolean tweetstatus;
	
	@ManyToMany(mappedBy = "tweet")
	private List<Users> users;

	@ManyToMany
	@JoinTable
	private List<Hashtag> hashtag;
	
	public List<Hashtag> getHashtag() {
		return hashtag;
	}

	public void setHashtag(List<Hashtag> hashtag) {
		this.hashtag = hashtag;
	}

	public List<Users> getUsers() {
		return users;
	}

	public void setUsers(List<Users> users) {
		this.users = users;
	}

	public long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPosted() {
		return posted;
	}

	public void setPosted(String posted) {
		this.posted = posted;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

//	public Tweet getInRepyOf() {
//		return inrepyof;
//	}
//
//	public void setInRepyOf(Tweet inRepyOf) {
//		this.inrepyof = inRepyOf;
//	}
//
//	public Tweet getRepostOf() {
//		return repostof;
//	}
//
//	public void setRepostOf(Tweet repostOf) {
//		repostof = repostOf;
//	}

	public boolean isTweetStatus() {
		return tweetstatus;
	}

	public void setTweetStatus(boolean tweetStatus) {
		tweetstatus = tweetStatus;
	}


}
