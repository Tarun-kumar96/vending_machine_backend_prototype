package com.inferentia.venus.pojo;

import java.util.UUID;

public class MachineProductRecipeInfo {
	private UUID machineID;
	private String productUniqueName;
	private Integer productUnitsRequired;
	private String productUnit;
	private String recipeCode;
	
	public MachineProductRecipeInfo() {
	}
	
	public MachineProductRecipeInfo(UUID machineID, String productUniqueName, Integer productUnitsRequired,
			String productUnit, String recipeCode) {
		this.machineID = machineID;
		this.productUniqueName = productUniqueName;
		this.productUnitsRequired = productUnitsRequired;
		this.productUnit = productUnit;
		this.recipeCode = recipeCode;
	}
	public UUID getMachineID() {
		return machineID;
	}
	public void setMachineID(UUID machineID) {
		this.machineID = machineID;
	}
	public String getProductUniqueName() {
		return productUniqueName;
	}
	public void setProductUniqueName(String productUniqueName) {
		this.productUniqueName = productUniqueName;
	}
	public Integer getProductUnitsRequired() {
		return productUnitsRequired;
	}
	public void setProductUnitsRequired(Integer productUnitsRequired) {
		this.productUnitsRequired = productUnitsRequired;
	}
	public String getProductUnit() {
		return productUnit;
	}
	public void setProductUnit(String productUnit) {
		this.productUnit = productUnit;
	}
	public String getRecipeCode() {
		return recipeCode;
	}
	public void setRecipeCode(String recipeCode) {
		this.recipeCode = recipeCode;
	}
	
}
