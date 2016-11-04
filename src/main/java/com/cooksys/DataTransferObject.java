package com.cooksys;

import org.springframework.stereotype.Component;

import com.cooksys.entity.Credentials;
import com.cooksys.entity.Profile;

public class DataTransferObject {
	
	private Credentials credentials;
	private Profile profile;
	
	public DataTransferObject(DataTransferObject o) {
		credentials = o.getCredentials();
		profile = o.getProfile();
	}
	
	public Credentials getCredentials() {
		return credentials;
	}
	public Profile getProfile() {
		return profile;
	}
	
}
