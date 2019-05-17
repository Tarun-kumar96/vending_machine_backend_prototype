package com.inferentia.venus.pojo;

import java.util.UUID;

public class UserCreationResponse {
	private UUID userID;
	private boolean userCreated;
	
	public UserCreationResponse(UUID userID, boolean userCreated) {
		this.userID = userID;
		this.userCreated = userCreated;
	}
	public UUID getUserID() {
		return userID;
	}
	public void setUserID(UUID userID) {
		this.userID = userID;
	}
	public boolean isUserCreated() {
		return userCreated;
	}
	public void setUserCreated(boolean userCreated) {
		this.userCreated = userCreated;
	}
	
	
}
