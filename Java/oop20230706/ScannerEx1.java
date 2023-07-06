package oop20230706;

import java.util.Scanner;
public class ScannerEx1 {

	public static void main(String[] args) {
    
		String x;
		String y;
		
		Scanner inputNumber = new Scanner(System.in);
		
		System.out.print("임의의 정수 x :");
		x = inputNumber.nextLine();
		int numberX =Integer.parseInt(x);
		
		System.out.print("임의의 정수 y :");
		y = inputNumber.nextLine();
		int numberY =Integer.parseInt(y);
		
		System.out.println();
		
		int result = numberX+numberY;
		System.out.println("두 정수의 합: " + result);
		inputNumber.close();
	}

}
