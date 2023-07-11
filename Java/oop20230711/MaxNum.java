package oop20230711;

import java.util.Scanner;

public class MaxNum {
	public static void main(String[] args) {
			
		
	//선언
	Scanner sc = new Scanner(System.in);
	int x,y,z= 0;
	int result = 0;
	
	//입력
	System.out.print("첫번째 정수값을 입력해주세요 : ");
	x = sc.nextInt();
	
	System.out.print("두번째 정수값을 입력해주세요 : ");
	y = sc.nextInt();
	
	System.out.print("세번째 정수값을 입력해주세요 : ");
	z = sc.nextInt();
	
	//처리
	result = (x > y && x > z)? x : (y> z) ? y : z;

	
	//출력
	System.out.printf("가장 큰 정수값은 %d입니다" , result);
	
	sc.close();
    }
}	