package com.hyon.sep08.main;

public class Patient {

	private String name;
	private double height;
	private double weight;
	private String photo;
	private double bmi;
	private String status;
	
	public Patient() {
		super();
	}

	public Patient(String name, double height, double weight, String photo, double bmi, String status) {
		super();
		this.name = name;
		this.height = height;
		this.weight = weight;
		this.photo = photo;
		this.bmi = bmi;
		this.status = status;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public double getBmi() {
		return bmi;
	}

	public void setBmi(double bmi) {
		this.bmi = bmi;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
    	
	
}
