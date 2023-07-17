package oop20230717;

import java.util.Scanner;

public class LoopEx8 {

	public static void main(String[] args) {

		int max = 0;
		int min = 0;
		int result = 2;
		
		Scanner sc = new Scanner(System.in);
		System.out.print("첫번째 자연수를 입력하세요: ");
		int num1 = sc.nextInt();
		System.out.print("두번째 자연수를 입력하세요: ");
		int num2 = sc.nextInt();
		
		if(num1>=num2) {max = num1; min = num2;} 
		else {min = num1; max = num2;}	
		
		if(max%min==0)
			System.out.printf("두 수의 최소공배수는 %d입니다." , max);
		
		else {
			result=2;
			while(!(result %max==0 && result %min ==0)) {
				result++;
			}
			System.out.printf("두 수의 최소공배수는 %d입니다." , result);	
		}
		
		sc.close();
	}

}


//18과 24의 최소공배수 : 72    while   