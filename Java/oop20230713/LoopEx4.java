package oop20230713;

import java.util.Scanner;

public class LoopEx4 {

	public static void main(String[] args) {
		
	//선언
	Scanner sc = new Scanner(System.in);
	int i;
	int result = 0;
	
	//입력
	System.out.print("첫번째 정수를 입력해주세요 > ");
	int x=sc.nextInt();
	
	System.out.print("두번째 정수를 입력해주세요 > ");
	int y=sc.nextInt();
	
	sc.close();
	
	//처리 및 출력 
	
	if(x<y) {
		for(i =x ; y-i>=0; i++ ) {
			result += i;
		}
	}
		
	else if(y<x){
		for(i =y ; x-i>=0; i++ ) {
			result += i;
		}
		
	}
	else {result = 0;}

	                         
	//출력
	System.out.printf("두 사이의 정수합의 값은 %d입니다", result);	
	
	
	}
}
    