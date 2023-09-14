package com.hyon.sep141.appledb;

public class Apple {
	private String A_location;
	private String A_color;
	private String A_flavor;
	private int A_price;
	private String A_introduce;
	
	
	public Apple() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Apple(String A_location, String A_color, String A_flavor, int A_price, String A_introduce) {
		super();
		this.A_location = A_location;
		this.A_color = A_color;
		this.A_flavor = A_flavor;
		this.A_price = A_price;
		this.A_introduce = A_introduce;
	}


	public String getA_location() {
		return A_location;
	}


	public void setA_location(String a_location) {
		A_location = a_location;
	}


	public String getA_color() {
		return A_color;
	}


	public void setA_color(String a_color) {
		A_color = a_color;
	}


	public String getA_flavor() {
		return A_flavor;
	}


	public void setA_flavor(String a_flavor) {
		A_flavor = a_flavor;
	}


	public int getA_price() {
		return A_price;
	}


	public void setA_price(int a_price) {
		A_price = a_price;
	}


	public String getA_introduce() {
		return A_introduce;
	}


	public void setA_introduce(String a_introduce) {
		A_introduce = a_introduce;
	}

	
}
