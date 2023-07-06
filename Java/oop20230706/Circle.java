package oop20230706;

import java.util.Scanner;

public class Circle {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("원의 반지름 길이: ");
		double radius = sc.nextDouble();
		
		double round = radius*3.14;
		double area = radius*radius*3.14;
		
		System.out.printf("원의 둘레: %.2fcm\n" ,round);
		System.out.printf("원의 넓이: %.2f㎠" ,area);
		
		sc.close();
		
	}

}
