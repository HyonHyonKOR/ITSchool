package oop20230717;

import java.util.Scanner;

public class ArrayEx4 {
	
	public static void main(String[] args) {
		
	int sum = 0;	
	Scanner sc = new Scanner(System.in);
	
	System.out.print("배열의 크기 : ");
	int size = sc.nextInt();
	int[] answer = new int[size];
	
	for(int i=0; i<answer.length; i++) {
		System.out.print(i + "번째 요소 : ");
		int input = sc.nextInt();
		sum += input;
	}
	
 	System.out.print("배열 요소의 합계 : " + sum);	
	
	  sc.close();
   }

}

