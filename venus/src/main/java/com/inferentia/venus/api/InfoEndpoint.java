package com.inferentia.venus.api;

import java.util.List;
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

import com.inferentia.venus.manager.InfoManager;
import com.inferentia.venus.pojo.UserCreationPayload;
import com.inferentia.venus.pojo.InfoCreationResponse;
import com.inferentia.venus.pojo.MachineProductRecipeInfo;
import com.inferentia.venus.pojo.UserInfo;
import com.inferentia.venus.pojo.VMInfo;
import com.inferentia.venus.pojo.VMInfoPayload;

@Component
@Path("v1.0/meta")
public class InfoEndpoint {

	private InfoManager infoManager;
	
	@Autowired
	 public InfoEndpoint(InfoManager infoManager) {
		 this.infoManager = infoManager;
	 }
		
	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/user/{userID}")
	public Response getUserInfo(@PathParam("userID") UUID userID) {
		UserInfo userInfo = infoManager.getUserInfo(userID);
		return Response.ok(userInfo).build();
	}
	
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/user")
	public Response addUserDetails(UserCreationPayload payload) {
		InfoCreationResponse resp = infoManager.createUser(payload);
		if(resp.isUserCreated()) {
			UserInfo userInfo = infoManager.getUserInfo(resp.getUuid());
			return Response.ok(userInfo).build();
		}
		return Response.notModified().build();
	}
	
	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/machine/{machineID}")
	public Response getMachineInfo(@PathParam("machineID") UUID machineID) {
		VMInfo info = infoManager.getVMInfo(machineID);
		return Response.ok(info).build();
	}
	
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/machine")
	public Response addMachineDetails(VMInfoPayload payload) {
		InfoCreationResponse resp = infoManager.addVMInfo(payload);
		if(resp.isUserCreated()) {
			VMInfo info = infoManager.getVMInfo(resp.getUuid());
			return Response.ok(info).build();
		}
		return Response.notModified().build();
	}
	
	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
		@Path("/machine/{machineID}/product-info")
	public Response getProductCodes(@PathParam("machineID") UUID machineID) {
		List<MachineProductRecipeInfo> allProductCodes = infoManager.getRecipeCodes(machineID);
		return Response.ok(allProductCodes).build();
	}
	
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/machine/product")
	public Response addProductCodes(MachineProductRecipeInfo info) {
		List<MachineProductRecipeInfo> allProductCodes = infoManager.addOrUpdateRecipeCode(info);
		if(allProductCodes!=null) {
			return Response.ok(info).build();
		}
		return Response.notModified().build();
	}

	
	
	
}
