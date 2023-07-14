package oop20230712;

import java.util.Scanner;

public class SelectionEx5 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("주사위의 눈금 1~6 중 하나를 입력해주세요 : ");
		int input =sc.nextInt();
		
		switch(input) {
		case 1: case 3: case 5:
			System.out.println("홀수 눈금"); break;
		case 2: case 4: case 6:
			System.out.println("짝수 눈금"); break;
		default: 
			System.out.println("주사위는 1~6까지의 눈금만 있어요!");
		}
		
		
		
	sc.close();

	}
}
