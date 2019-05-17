package com.inferentia.venus.api;

import java.util.UUID;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.inferentia.venus.manager.UserManager;
import com.inferentia.venus.pojo.UserCreationPayload;
import com.inferentia.venus.pojo.UserCreationResponse;
import com.inferentia.venus.pojo.UserInfo;

@Component
@Path("v1.0/meta")
public class UserInfoEndpoint {

	private UserManager userManager;
	
	@Autowired
	 public UserInfoEndpoint(UserManager userManager) {
		 this.userManager = userManager;
	 }
		
	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/user/{userID}")
	public Response getUserCreditInfo(@PathParam("userID") UUID userID) {
		UserInfo userInfo = userManager.getUserInfo(userID);
		return Response.ok(userInfo).build();
	}
	
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/user")
	public Response getUserCreditInfo(UserCreationPayload payload) {
		UserCreationResponse resp = userManager.createUser(payload);
		if(resp.isUserCreated()) {
			UserInfo userInfo = userManager.getUserInfo(resp.getUserID());
			return Response.ok(userInfo).build();
		}
		return Response.notModified().build();
	}
	
}
