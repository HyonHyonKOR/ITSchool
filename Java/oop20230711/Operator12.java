package oop20230711;

import java.util.Scanner;

public class Operator12 {

	public static void main(String[] args) {
		//char 변수를 키보드로(단일)문자를 입력 받아
		//그 값이 대문자인지를 판별하여
		//다문자이면 "입력완료"를 출력
		//그렇지 않으면 "입력오류"를 출력
		//삼항(조건)연산자
		
		//선언
		Scanner sc = new Scanner(System.in);
		String inputData = "";
		 
		//입력
		System.out.print("문자를 입력해주세요 : ");
		inputData = sc.next();
		char capital = inputData.charAt(0);
		
		//처리
		//String result = (capital>=65 && capital<=90)? "입력완료": "입력오류";
		String result = (capital>='A' && capital<='Z')? "입력완료": "입력오류";
		//어차피 문자도 내부적으로는 정수이기 때문에 비교연산 가능하다 
		
		//출력
		System.out.println(result);
		sc.close();
	}
}
