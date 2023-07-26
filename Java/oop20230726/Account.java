package oop20230726;

public class Account {
	
	private String accId;
	private String name;
	private int balance;
	
	public Account() {
		this.accId = "100-01-1000";
		this.name = "고객명";
		this.balance = 1000;
	}
	
	public Account(String accId, String name) {
		this.accId = accId;
		this.name = name;
		//this.balance = 1;
	}
	
	public Account(String accId, String name, int balance) {
		this.accId = accId;
		this.name = name;
		this.balance = balance;
	}
	
	
	
	public void deposit(int money) {
		this.balance += money;
	}
	public void withdraw(int money) {
		this.balance -= money;
	}
	
	public void setBalance(int money) {
		this.balance = money;
	}
	
	public void showBalance() {
		System.out.println("===계좌정보===");
		System.out.println("계좌번호 : " + this.accId);
		System.out.println("이름 : " + this.name);
		System.out.println("잔액 : " + this.balance);
	}

}
