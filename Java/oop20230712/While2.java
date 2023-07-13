package oop20230712;

import java.util.Scanner;

public class While2 {
	
	public static void main(String[] args) {
		// n단 구구단 출력하기(9회 출력)
		
		Scanner sc = new Scanner(System.in);
		
		
	    int i = 1;
		
		System.out.print("원하는 구구단의 단을 입력해주세요> ");
		int n = sc.nextInt();
		System.out.println("-----" + n + "단-----");
		
		while(i<10) {
			System.out.println(n + " x " + i + " = " + (n*i));
			++i;
		}
		
		sc.close();
		
	}//main end
}//class end
