package oop20230726;

public class AccountTest {

	public static void main(String[] args) {
		Account acc1 = new Account();
		Account acc2 = new Account("100-01-5678","홍길동");
		Account acc3 = new Account("100-01-5679","고길동",100000);
		
		acc1.showBalance();
		acc2.showBalance();
		acc3.showBalance();
		
		acc2.setBalance(60000);
		acc2.showBalance();
		acc2.deposit(500);
		acc2.showBalance();

	}

}
