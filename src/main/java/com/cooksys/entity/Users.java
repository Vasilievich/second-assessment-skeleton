package com.cooksys.entity;

import java.sql.Timestamp;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.JoinColumn;

@Entity
public class Users {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column
	private String username;

	@Column
	private String firstname;
	
	@Column
	private String lastname;
	
	@Column
	private String email;
	
	@Column
	private String phone;

	@Column
	private String timestamps;
	
	@Column
	private String password;
	
	@Column
	private boolean deletestatus;

	@ManyToMany
	@JoinTable(name = "usertweets")
	private List<Tweet> tweet;
	
	
//	@ManyToMany
//	@JoinTable
//	private List<Hashtag> Hashtag;
 	
	
//	public List<Hashtag> getHashtags() {
//		return Hashtag;
//	}
//	
//	public void setHashtags(List<Hashtag> hashtags) {
//		Hashtag = hashtags;
//	}
	
	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getTimestamps() {
		return timestamps;
	}

	public void setTimestamps(String timestamps) {
		this.timestamps = timestamps;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public boolean isDeleteStatus() {
		return deletestatus;
	}

	public void setDeletestatus(boolean deletestatus) {
		this.deletestatus = deletestatus;
	}

	public List<Tweet> getTweets() {
		return tweet;
	}

	public void setTweets(List<Tweet> tweets) {
		this.tweet = tweets;
	}

	public Profile getProfile() {
		return new Profile(email);
	}
	
	public Credentials getCredentials() {
		return new Credentials(username, password);
	}
}