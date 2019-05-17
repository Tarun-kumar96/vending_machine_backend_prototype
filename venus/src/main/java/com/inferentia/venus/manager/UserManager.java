package com.inferentia.venus.manager;

import java.util.UUID;

import com.inferentia.venus.dao.UserInfoDao;
import com.inferentia.venus.pojo.UserCreationPayload;
import com.inferentia.venus.pojo.UserCreationResponse;
import com.inferentia.venus.pojo.UserInfo;
import com.mysql.jdbc.Util;

public class UserManager {

	private UserInfoDao userInfoDao;
	
	
	public UserManager(UserInfoDao userInfoDao) {
		this.userInfoDao = userInfoDao;
	}
	
	public UserInfo getUserInfo(UUID userID) {
		UserInfo userInfo = userInfoDao.getUserInfo(userID);
		return userInfo;
	}
	
	public UserCreationResponse createUser(UserCreationPayload payload) {
		UUID userID = UUID.randomUUID();
		int now = (int)System.currentTimeMillis()/1000;
		UserInfo userInfo = new UserInfo(userID, payload.getUserName(), payload.getMobileNumber(), now);
		boolean isUserCreated = userInfoDao.createUser(userInfo);
		return new UserCreationResponse(userID, isUserCreated);
	}
}
