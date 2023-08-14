package oop20230814.exception;

import java.util.*;

//Java
//    예외처리가 강제
//Python
//    처리하기 싫으면 안해도 됨
public class EMain3 {
	public static void main(String[] args) {
		//가격 /무게를 입력받아서 정수로
		//g당 가격이 얼마인지 값을 구해서 main에 출력
		//기능에 대한것은 class하나 열어서
		Scanner sc = new Scanner(System.in);
		System.out.print("상품의 가격을 입력해주세요 : ");
		int price = sc.nextInt();
		System.out.print("상품의 무게를 입력해주세요(g) : ");
		int weight = sc.nextInt();
		System.out.println("=========");
		
		int z1 = Calculator.getGramPerPrice(price, weight);
		System.out.printf("g당 가격은 : %d원\n" , z1);
		
		try {
			int z2 = Calculator.getGramPerPrice(price,weight);
			System.out.printf("g당 가격은 : %d원\n" , z2);
		}catch(Exception e) {
			e.printStackTrace();
		}
		sc.close();
     	}

       //다른 메소드에서 try-catch ... -> 월권 행위...!!! / main에서만 사용!
       //throws : main이외의 메소드들에서 사용
   
}
	