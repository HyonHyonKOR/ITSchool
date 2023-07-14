package oop20230712;

import java.util.Scanner;

public class SelectionEx7 {

	public static void main(String[] args) {
		
		double result = 0.0;
		Scanner sc = new Scanner(System.in);
		
		System.out.print("산술연산자 +,-,*,/,% 중 하나를 입력해주세요 : ");
		String arithOpr = sc.next();
		System.out.print("첫 번째 숫자를 입력해주세요 : ");
		Double firNum = sc.nextDouble();
		System.out.print("두 번째 숫자를 입력해주세요 : : ");
		Double secNum = sc.nextDouble();
		
		
		switch(arithOpr) {
			case "+": result = firNum + secNum; System.out.printf("두 수의 합은 %.2f입니다." , result);break;  
			case "-": result = firNum - secNum; System.out.printf("두 수의 차는 %.2f입니다." , result);break;
			case "*": result = firNum * secNum; System.out.printf("두 수의 곱은 %.2f입니다." , result);break;
			case "/": result = firNum / secNum; System.out.printf("두 수의 몫은 %.2f입니다." , result);break;
			case "%": result = firNum % secNum; System.out.printf("두 수의 나머지는 %.2f입니다." , result);break;
			default : System.out.println("잘못 입력하셨습니다.");
		}
		
		
		sc.close();
	}//main()end

}//Class end

//클래스명(파일명) : SelectionEx7.java
//switch 문 이용
//산술연산자 중 하나를 선택하게 하고,
//실수 두 개를 입력 받아서

//+을 선택했으면 두 수 더하기
//-을 선택했으면 두 수 빼기
//*을 선택했으면 두 수 곱하기
///을 선택했으면 두 수 나누기
//%을 선택했으면 두 수의 나머지를 구하여 결과값 출력 하기