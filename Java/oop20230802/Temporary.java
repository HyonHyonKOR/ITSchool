package oop20230802;

public class Temporary extends Employee{
	
	private String name;
	private int timePay;
	private int time;
	
	public Temporary() {}
	
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getTimePay() {
		return timePay;
	}

	public void setTimePay(int timePay) {
		this.timePay = timePay;
	}


	public int getTime() {
		return time;
	}


	public void setTime(int time) {
		this.time = time;
	}



	@Override
	public int getPay() {
		return timePay*time;
	}
	

}
