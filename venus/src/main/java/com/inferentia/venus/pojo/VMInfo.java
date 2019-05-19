package com.inferentia.venus.pojo;

import java.util.UUID;

public class VMInfo {
	private UUID machineID;
	private IngredientType ingredientType;
	private Integer collectorNumber;
	private String ingredientName;
	private Integer ingredientAmount;
	private String ingredientUnit;
	public UUID getMachineID() {
		return machineID;
	}
	public void setMachineID(UUID machineID) {
		this.machineID = machineID;
	}
	public IngredientType getIngredientType() {
		return ingredientType;
	}
	public void setIngredientType(IngredientType ingredientType) {
		this.ingredientType = ingredientType;
	}
	public Integer getCollectorNumber() {
		return collectorNumber;
	}
	public void setCollectorNumber(Integer collectorNumber) {
		this.collectorNumber = collectorNumber;
	}
	public String getIngredientName() {
		return ingredientName;
	}
	public void setIngredientName(String ingredientName) {
		this.ingredientName = ingredientName;
	}
	public Integer getIngredientAmount() {
		return ingredientAmount;
	}
	public void setIngredientAmount(Integer ingredientAmount) {
		this.ingredientAmount = ingredientAmount;
	}
	public String getIngredientUnit() {
		return ingredientUnit;
	}
	public void setIngredientUnit(String ingredientUnit) {
		this.ingredientUnit = ingredientUnit;
	}
	
}
