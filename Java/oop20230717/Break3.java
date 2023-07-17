package oop20230717;

import java.util.Scanner;

public class Break3 {

	
	
	
	
	public static void main(String[] args) {
		//정수를 "계속해서"
		//입력 받고,
		//입력받은 정수가 0이면, 반복을 끝내고
		//입력한 정수(number)의 합계(total)를 출력하세요.
		
		Scanner sc = new Scanner(System.in);
		int total= 0;
		
		
		while(true) {
			System.out.print("정수 입력:");
			int number = sc.nextInt();
			if(number==0) {
				break;
			}
			total += number;
		}
	
		if(total==0) System.out.println("종료");
		else System.out.println("입력한 정수합: " + total);
		
		sc.close();
 		
	}

}
