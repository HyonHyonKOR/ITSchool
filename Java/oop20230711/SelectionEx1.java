package oop20230711;

import java.util.Scanner;

public class SelectionEx1 {

	public static void main(String[] args) {
		
		
		//선언
		Scanner sc = new Scanner(System.in);
		String input = "";
		
		//입력
		System.out.print("성별을 입력해주세요(M/F) : ");  
		input = sc.next();
		
		//처리 및 출력
		if(input.equals("M"))
		{
			System.out.println("남자이시군요");  
		}
		else if(input.equals("F")) 	
		{
			System.out.println("여자이시군요");  //_거짓 실행문;
		}
		else 
		{System.out.println("잘못 입력했습니다!");}
		
		sc.close();
	}

}
		
		
