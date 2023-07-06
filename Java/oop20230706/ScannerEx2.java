package oop20230706;

import java.util.Scanner;

public class ScannerEx2 {

	public static void main(String[] args) {
		//두 정수를 키보드로 입력받아
		//두 정수의 합을 출력하는
		//프로그램
		Scanner sc = new Scanner(System.in);
		
		//선언
		int a = 0;
		int b = 0;
		int c = 0;
		//입력
		System.out.print("첫번째 정수: ");
		a = sc.nextInt();     //문자열을 정수로 변환해서 담는 메소드 + nextLine();
		System.out.print("두번째 정수: ");
		b = sc.nextInt();     //문자열을 정수로 변환해서 담는 메소드 + nextLine();
		
		//출력
		c = a+b;
		System.out.println("정수합계 출력 :" + c );
		
		sc.close();
	}

}
