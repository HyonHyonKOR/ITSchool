package oop20230712;

import java.util.Scanner;

public class SelectionEx4 {
	public static void main(String[] args) {
		
	

	//선언
	Scanner sc = new Scanner(System.in);
	int month = 0;
				
	//입력
	System.out.println("오늘은 몇 월인지 입력해주세요 (입력 예시: 7)");
	System.out.print("입력>");
	month = sc.nextInt();
	
	//처리 및 출력
	switch(month) {
	
	case 1:
	case 2:
	case 3:
	System.out.println("1사분기");
	break;
	
	case 4:
	case 5:
	case 6:
	System.out.println("2사분기");	
	break;
	
	case 7:
	case 8:
	case 9:
	System.out.println("3사분기");	
	break;
	
	case 10:
	case 11:
	case 12:
	System.out.println("4사분기");	
	break;
	
	default:
	System.out.println("잘못 입력하였습니다!");	
	} //switch
	
	sc.close();
	
	
  }//main
} //class