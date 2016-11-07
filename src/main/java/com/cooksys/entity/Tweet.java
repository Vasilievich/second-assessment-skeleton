package com.cooksys.entity;

import java.util.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;



import java.util.List;

@Entity
public class Tweet {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "author")
	private String author;
	
	@Column(name = "posted")
	private String posted;

	@Column(name = "content")
	private String content;
	
//	@Column
//	private Tweet inrepyof;
//	
//	@Column
//	private Tweet repostof;
	
	@Column(name = "active")
	private boolean active;

	@ManyToMany(mappedBy = "tweet")
	@JsonIgnore
	private List<Users> users;

	@ManyToMany
	@JoinTable(name = "tweethashtags")
	private List<Hashtag> hashtag;

	@ManyToMany(mappedBy = "tweetlike")
	private List<Users> likedby;
		
	public Tweet() {}
	public Tweet(String author, String content) {
		Date date = new Date();
		this.posted = (new Timestamp(date.getTime())).toString();
		this.author = author;
		this.content = content;
		this.active = true;
	}
	

	@JsonIgnore
	public List<Users> getlikedby() {
		return likedby;
	}

	public void setUserlike(List<Users> likedby) {
		this.likedby = likedby;
	}

	@JsonIgnore
	public List<Hashtag> getHashtags() {
		return hashtag;
	}
	
	public void setHashtag(List<Hashtag> hashtag) {
		this.hashtag = hashtag;
	}

	@JsonIgnore
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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
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

	public boolean isTweetActive() {
		return active;
	}

	public void setTweetActive(boolean tweetActive) {
		active = tweetActive;
	}


}
