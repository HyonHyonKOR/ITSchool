package oop20230802;

public class Permanert extends Employee {

	private String name;
	private int basicPay;
	private int bonus;
	
	public Permanert() {}
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public int getBasicPay() {
		return basicPay;
	}


	public void setBasicPay(int basicPay) {
		this.basicPay = basicPay;
	}


	public int getBonus() {
		return bonus;
	}


	public void setBonus(int bonus) {
		this.bonus = bonus;
	}


	@Override
	public int getPay() {
		return basicPay+bonus;
	}
}
