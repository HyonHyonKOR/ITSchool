package oop20230712;

import java.util.*;

public class SelectionEx2 {

	public static void main(String[] args) {

	//선언
	Scanner sc = new Scanner(System.in);
	char sign = ' ';
	
	
	//입력
	System.out.println("[+],[-],[*],[/] 중 하나를 입력해주세요. (입력예: + , 출력예: 더하기)");
	System.out.print("입력>");
	sign = sc.next().charAt(0); 
	
	//처리 및 출력
	switch(sign) {
	case '+':
	System.out.println("더하기");	
	break;
	
	case '-':
	System.out.println("빼기");	
	break;
		
	case '*':
		System.out.println("곱하기");	
		break;
		
	case '/':
		System.out.println("나누기");	
		break;
		
	default :
		System.out.println("잘못 입력!");			
	}
	
	sc.close();
		
		
	}

}
