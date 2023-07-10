package oop20230710;

import java.util.*;


public class Age {

	public static void main(String[] args) {
		
	Scanner sc = new Scanner(System.in);	
	Calendar cal= Calendar.getInstance();
		
	System.out.print("출생년도>");	
	int year  = sc.nextInt();	
	
	int thisYear = cal.get(Calendar.YEAR);
    
	int age= thisYear-year+1;
	System.out.println("당신의 연나이는 " + age + "세 입니다.");
	
	sc.close();
	}

}


/*# Scanner 클래스를 사용하여, 산술연산하여 출력 해보기!

[3] 출생 년도, 월, 일을 입력하여 "연나이"를 계산하는 프로그램

// 클래스명(파일명) : Age.java

// 사용자가 출생 년도, 월, 일을 입력

//  "연나이"를 계산

// 변수명 각자가 작성해보기!
 * 
 */

