package oop20230712;

import java.util.Scanner;

public class LoopEx1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.print("정수를 입력하시오.> ");
		int num = scanner.nextInt();
		int sum = 0;
		while (num>0) {
			sum += num%10;
			num /=10;
		}
		System.out.println("자릿수 합계: " + sum);
		scanner.close();
	}

}
