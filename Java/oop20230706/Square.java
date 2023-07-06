package oop20230706;

import java.util.Scanner;

public class Square {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("사각형의 가로변 길이: ");
		double width = sc.nextDouble();
		
		System.out.print("사각형의 높이: ");
		double height = sc.nextDouble();
		
		double round = (width + height)*2;
		double area = width*height;
		
		System.out.printf("사각형의 둘레: %.2fcm\n" , round);
		System.out.printf("사각형의 넓이: %.2f㎠" , area);
		
		sc.close();
	}
}
