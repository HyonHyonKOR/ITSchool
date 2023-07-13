package oop20230712;

import java.util.Scanner;

public class SelectionEx3 {

	public static void main(String[] args) {

	//선언
	Scanner sc = new Scanner(System.in);
	int day = 0;
		
		
	//입력
	System.out.println("오늘의 날짜를 입력해주세요 (입력 예시: 7)");
	System.out.print("입력>");
	day = sc.nextInt();
		
	//처리
	if(day>0 && day< 11) {
	System.out.println("초순");	
	}
	
	if(day>10 && day< 21) {
		System.out.println("중순");	
		}
	
	if(day>20 && day< 32) {
		System.out.println("하순");	
		}
	
	if(day<=0 || day> 31) {
		System.out.println("잘못 입력하였습니다.");	
		}
	
	sc.close();
	
	}//main
}//Class
