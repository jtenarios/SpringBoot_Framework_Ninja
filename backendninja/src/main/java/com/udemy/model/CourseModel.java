package com.udemy.model;

public class CourseModel {

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	private int id; // no debería ponerlo pero me falla el checkpoint 2
	private String name;
	private String description;
	private int price;
	private int hours;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getHours() {
		return hours;
	}

	public void setHours(int hours) {
		this.hours = hours;
	}

	// Constructor con todos los campos
	public CourseModel(String name, String description, int price, int hours) {
		super();
		this.name = name;
		this.description = description;
		this.price = price;
		this.hours = hours;
	}

	// Constructor vacio
	public CourseModel() {
	}
	
	@Override
	public String toString() {
		return "CourseModel [name=" + name + ", description=" + description + ", price=" + price + ", hours=" + hours + "]";
	}	

}
