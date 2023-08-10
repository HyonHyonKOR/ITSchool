package oop20230810;

import java.util.*;

public class Emain2 {

	public static void main(String[] args) {
		getChange();
	}
	
	public static Scanner sc = new Scanner(System.in);
	
	public static int setprice(){
		System.out.print("물건 가격 : ");
		int price = sc.nextInt();
		return (price >= 0 ) ? price : setprice();
	}
	
	public static int payMoney(){
		System.out.print("지불할 돈 : ");
		int money = sc.nextInt();
		return (money >= 0 ) ? money : payMoney();
	}
	
	public static int calculateChange(int price, int money){
		int change = (money - price);
		if(money - price >= 0) { 
			return change;
		}else {
			System.out.println("돈이 부족합니다. 다시 입력하세요.");
			money = payMoney();
			return calculateChange(price, money);
		}
	}	
	
	public static void giveChange(int change) {
		if(change == 0) {
			System.out.println("딱 맞는 금액을 지불했습니다.");
		}
		while(change>0) {
			System.out.printf("거스름 돈 : %d원\n",change);
			System.out.printf("50000원 : %d장\n",change/50000);
			change = change%=50000;
			System.out.printf("10000원 : %d장\n",change/10000);
			change = change%=10000;
			System.out.printf(" 5000원 : %d장\n",change/5000);
			change = change%=5000;
			System.out.printf(" 1000원 : %d장\n",change/1000);
			change = change%=1000;
			System.out.printf("  500원 : %d개\n",change/500);
			change  = change%=500;
			System.out.printf("  100원 : %d개\n",change/100);
			change = change%=100;
			System.out.printf("   50원 : %d개\n",change/50);
			change = change%=50;
			System.out.printf("   10원 : %d개\n",change/10);
			change = change%=1;
		}
	}
	
	public static void getChange() {
		int price = setprice();
		int money = payMoney();
		int change = calculateChange(price,money);
		giveChange(change);
	}
}


