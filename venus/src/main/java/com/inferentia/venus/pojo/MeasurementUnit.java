package com.inferentia.venus.pojo;

public enum MeasurementUnit {

	GRAMS("gm"),
	MILLILITRES("ml");
	
	private String abbrev;
	private MeasurementUnit(String abbrev) {
		this.abbrev = abbrev;
	}
}
