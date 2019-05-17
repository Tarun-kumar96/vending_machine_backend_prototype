package com.inferentia.venus.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.inferentia.venus.pojo.UserInfo;

public class UserInfoDao {
 private JdbcTemplate jdbcTemplate;
 
 private final static String GET_USER_INFO = "select * from basic_user_details where user_id=?";
 
 private final static String INSERT_USER_INFO = "insert into basic_user_details values(?,?,?,?)";
 
 private final static String UPDATE_USER_INFO = "update basic_user_details set ";
 

 public UserInfo getUserInfo(UUID userID) {
	 List<UserInfo> userInfoList = jdbcTemplate.query(GET_USER_INFO,Arrays.asList(userID).toArray(),new UserInfoMapper());
	 if(userInfoList.size()>1) {
		 System.err.println("Multiple entries present for the same user" + userID);
	 }
	 return userInfoList.get(0);
 }
 
 
 public boolean createUser(UserInfo userInfo) {
	 List<Object> args = new ArrayList<Object>();
	 int rows = jdbcTemplate.update(INSERT_USER_INFO, args.toArray());
	 if(rows==1) {
		 return true;
	 }
	 return false;
 }

}

class UserInfoMapper implements RowMapper<UserInfo>{

	public UserInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
		UserInfo userInfo = new UserInfo();
		userInfo.setMobileNumber(rs.getString("mobile_number"));
		userInfo.setUserName(rs.getString("name"));
		userInfo.setRegistrationDate(rs.getInt("registered_date"));
		return userInfo;
	}
}
