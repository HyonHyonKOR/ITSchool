package oop20230711;

import java.util.Scanner;

public class Operator11 {

	public static void main(String[] args) {
		//조건연산자 10의 짝수(2의 배수) 판별: 82page 변형
		//삼항 연산자와 % 연산자 활용

		
		//선언
		int num = 0;
		int result =0;
		Scanner sc = new Scanner(System.in);
		
		//입력
		System.out.print("숫자를 입력해주세요>");
		num = sc.nextInt();
		
		//처리
	    result = (num % 2 == 0 || num % 3 == 0)? 1 : 0;
	    
	    //출력
		System.out.println(result);
		
		sc.close();
	}

}
