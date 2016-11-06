package com.cooksys.entity;

import java.util.List;
import java.sql.Timestamp;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.MapKeyJoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.JoinColumn;

@Entity
public class Users {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "username")
	private String username;

	@Column(name = "firstname", nullable = true)
	private String firstname;
	
	@Column(name = "lastname")
	private String lastname;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "phone")
	private String phone;

	@Column(name = "timestamps")
	private String timestamps;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "active")
	private boolean active;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "usertweets",
	joinColumns = @JoinColumn(name = "users_id"),
	inverseJoinColumns = @JoinColumn(name = "tweet_id"))
	@JsonIgnore
	private List<Tweet> tweet;
	
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "followings",
	joinColumns = @JoinColumn(name ="following"),
	inverseJoinColumns = @JoinColumn(name = "users"))
	private List<Users> followings;
	
	@ManyToMany(mappedBy = "followings")
	private List<Users> follower;
	
	@ManyToMany
	@JoinTable(name = "followers",
	joinColumns = @JoinColumn(name ="follower"),
	inverseJoinColumns = @JoinColumn(name = "users"))
	private List<Users> followers;
	
	@ManyToMany(mappedBy = "followers")
	private List<Users> following;
	
	@JsonIgnore
	public List<Users> getFollowers() {
		return followers;
	}

	public void setFollowers(List<Users> followers) {
		this.followers = followers;
	}
	@JsonIgnore
	public List<Users> getFollowings() {
		return followings;
	}

	public void setFollowings(List<Users> followings) {
		this.followings = followings;
	}
	@JsonIgnore
	public List<Users> getFollowing() {
		return following;
	}

	public void setFollowing(List<Users> following) {
		this.following = following;
	}
	@JsonIgnore
	public List<Users> getFollower() {
		return follower;
	}

	public void setFollower(List<Users> follower) {
		this.follower = follower;
	}



	public Users(){
	}
	
	public Users(Credentials credential, Profile profile, String time) {
		this.username = credential.getUsername();
		this.email = profile.getEmail();
		this.timestamps = time;
		this.firstname = profile.getFirstname();
		this.lastname = profile.getLastname();
		this.phone = profile.getPhone();
		this.password = credential.getPassword();
		this.active = true;
	}
	
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
		Date date = new Date();
		this.timestamps = (new Timestamp (date.getTime())).toString();
		return timestamps;
	}

	public void setTimestamps(String timestamps) {
		Date date = new Date();
		this.timestamps = (new Timestamp (date.getTime())).toString();
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

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean deletestatus) {
		this.active = deletestatus;
	}
	@JsonIgnore
	public List<Tweet> getTweets() {
		return tweet;
	}

	public void setTweets(List<Tweet> tweets) {
		this.tweet = tweets;
	}
}