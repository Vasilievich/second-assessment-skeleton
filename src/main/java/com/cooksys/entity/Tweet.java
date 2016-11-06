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

	@Column(name = "context", nullable = true)
	private String context;
	
//	@Column
//	private Tweet inrepyof;
//	
//	@Column
//	private Tweet repostof;
	
	@Column(name = "active")
	private boolean active;

	@ManyToMany(mappedBy = "tweet")
	private List<Users> users;

	@ManyToMany
	@JoinTable(name = "tweethashtags")
	private List<Hashtag> hashtag;

	@ManyToOne
	@JoinTable(name = "likes")
	private Tweet userlike;
	
	@OneToMany(mappedBy = "likes")
	private List<Users> liker;
	
	public Tweet(String author, String context) {
		this.author = author;
		this.context = context;
		this.active = true;
	}
	
	public Tweet getUserlike() {
		return userlike;
	}

	public void setUserlike(Tweet userlike) {
		this.userlike = userlike;
	}

	public List<Users> getLiker() {
		return liker;
	}

	public void setLiker(List<Users> liker) {
		this.liker = liker;
	}

	@JsonIgnore
	public List<Hashtag> getHashtags() {
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
		Date date = new Date();
		this.posted = (new Timestamp(date.getTime())).toString();
		return posted;
	}

	public void setPosted(String posted) {
		Date date = new Date();
		this.posted = (new Timestamp(date.getTime())).toString();
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

	public boolean isTweetActive() {
		return active;
	}

	public void setTweetActive(boolean tweetActive) {
		active = tweetActive;
	}


}
