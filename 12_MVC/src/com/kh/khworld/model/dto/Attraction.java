package com.kh.khworld.model.dto;

public class Attraction {
	private String name;
	private String heightLimit;
	private String location;
	
	public Attraction(String name, String heightLimit, String location) {
		this.name = name;
		this.heightLimit = heightLimit;
		this.location = location;
				
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getHeightLimit() {
		return heightLimit;
	}
	public void setHeightLimit(String heightLimit) {
		this.heightLimit = heightLimit;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	

}
