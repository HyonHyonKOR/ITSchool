package com.hyon.aug28.torikizoku;

public class Torikizoku {
	  private String location;
	  private String name;
	  private int seat;
	  
	public Torikizoku() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Torikizoku(String location, String name, int seat) {
		super();
		this.location = location;
		this.name = name;
		this.seat = seat;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSeat() {
		return seat;
	}

	public void setSeat(int seat) {
		this.seat = seat;
	}
	  
	  
	  
}
