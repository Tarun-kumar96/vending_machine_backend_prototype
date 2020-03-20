package com.inferentia.venus.manager;

import java.util.List;
import java.util.UUID;

import org.springframework.context.ApplicationContext;

import com.inferentia.venus.dao.MachineProductRecipesDao;
import com.inferentia.venus.dao.UserInfoDao;
import com.inferentia.venus.dao.VMInfoDao;
import com.inferentia.venus.pojo.UserCreationPayload;
import com.inferentia.venus.pojo.InfoCreationResponse;
import com.inferentia.venus.pojo.MachineProductRecipeInfo;
import com.inferentia.venus.pojo.UserInfo;
import com.inferentia.venus.pojo.VMInfo;
import com.inferentia.venus.pojo.VMInfoPayload;

public class InfoManager {

	private UserInfoDao userInfoDao;
	private VMInfoDao vmInfoDao;
	private MachineProductRecipesDao productRecipeDao;
	
	
	public InfoManager(UserInfoDao userInfoDao,VMInfoDao vmInfoDao,MachineProductRecipesDao productRecipeDao) {
		this.userInfoDao = userInfoDao;
		this.vmInfoDao = vmInfoDao;
		this.productRecipeDao= productRecipeDao;
	}
	
	public UserInfo getUserInfo(UUID userID) {
		UserInfo userInfo = userInfoDao.getUserInfo(userID);
		return userInfo;
	}
	
	public InfoCreationResponse createUser(UserCreationPayload payload) {
		UUID userID = UUID.randomUUID();
		int now = (int)System.currentTimeMillis()/1000;
		UserInfo userInfo = new UserInfo(userID, payload.getUserName(), payload.getMobileNumber(), now);
		boolean isUserCreated = userInfoDao.createUser(userInfo);
		return new InfoCreationResponse(userID, isUserCreated);
	}

	public VMInfo getVMInfo(UUID machineID) {
		return vmInfoDao.getVMInfo(machineID);
	}
	
	public InfoCreationResponse addVMInfo(VMInfoPayload payload) {
		UUID randomMachineID= UUID.randomUUID();
		VMInfo vmInfo = new VMInfo(randomMachineID, payload.getIngredientType(), payload.getCollectorNumber(), 
				payload.getIngredientName(), payload.getIngredientAmount(), payload.getIngredientUnit());
		boolean isCreated=  vmInfoDao.createMachineDetails(vmInfo);
		InfoCreationResponse response = new InfoCreationResponse(randomMachineID, isCreated);
		return response;
		
	}
	
	
	public List<MachineProductRecipeInfo> getRecipeCodes(UUID machineID) {
		return productRecipeDao.getRecipeCodes(machineID);
	}
	
	public List<MachineProductRecipeInfo> addOrUpdateRecipeCode(MachineProductRecipeInfo info) {
		boolean isAdded = productRecipeDao.addNewProduct(info);
		if(isAdded) {
			return productRecipeDao.getRecipeCodes(info.getMachineID());
		}
		return null;
	}
	
}
