package com.example.jdbcdemo.domain;

public class Drink {
	
	private long id;
	
	private String name;
	private int price;
	
	public Drink() {
	}
	
	public Drink(String name, int price) {
		super();
		this.name = name;
		this.price = price;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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
	
}
