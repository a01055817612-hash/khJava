package com.kh.used.model.dto;

public class UsedItem {
	
	private String name;
	private int price;
	private String condition;
	private String location;
	
	public UsedItem(String name, int price, String condition, String location) {
		this.name = name;
		this.price = price;
		this.condition = condition;
		this.location = location;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getCondition() {
		return condition;
	}
	public void setCondition(String condition) {
		this.condition = condition;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	@Override
	public String toString() {
		return "UsedItem [ name = " + name + " ,price = " + price + ",condition = " 
							+ condition + ",location = " + location + "]";
	}

}
