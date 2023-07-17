package oop20230713;

public class For5 {
	public static void main(String[] args) {
		// 프로그래밍 기초 알고리즘 : 갯수와 누적 
		// (1) 1(이상) ~ 10(이하)의 짝수의 갯수 출력
		int count = 0;
		
		for(int i = 1; i<=10; i++) {
			if(i%2 ==0) {
				count++;     
			}
		}
		System.out.println("1~10 사이의 짝수의 갯수 : " + count);
		System.out.println();
		//누적의 성질을 이용 
		//합계 누적은 반드시 0으로 초기화한다.
		
		
		// 프로그래밍 기초 알고리즘: 누적 합계(누적) , 누적 곱(누승)
		// (2) 1 ~ 100(이하) 사이의 홀수와 짝수의 합계
		
		int oddSum = 0;
		int evenSum= 0;
		
		for(int i = 1; i<=100; i++) {
			if(i%2 == 1) {
				oddSum += i;
			}
			else 
				evenSum += i;
		}
		
		System.out.println("홀수의 합 : " +oddSum);
		System.out.println("짝수의 합 : " +evenSum);
		
		System.out.println();
		
		//(3) 1 ~ 5 (이하) 사이의 정수의 누적 곱셈의 결과
		int result = 1;
		
		for(int i =1; i<=5; i++) {
			result *= i;
		}
			
		System.out.println("1~5 사이의 정수의 누적 곱셈 : " + result);
		
		
		//(4) 누적 곱셈(누승) -> 팩토리얼 : 5! = 5*4*3*2*1 = 1*2*3*4*5 = 120
		
		int fac = 1;
		for(int n =5; n>=1; n--) {
			fac *= n;
		}
		
		System.out.println();
		System.out.println("5! : " + fac);
		
		
		//(5) for문 1개를 이용하여 다음과 같이 출력하기
		System.out.println();     //줄바꿈(개형, newline)
		System.out.printf("\n");  //줄바꿈(개형, newline)
		
		int cnt =0;
		
		for(char ch = 'A'; ch <= 'Z'; ch++) {
			System.out.print(ch);
			cnt++;
			if(cnt%5 ==0) {
				System.out.println();
			}
		}
		
	    System.out.println();
	    System.out.println();
		
		//(6) 2023년 윤년 판단(윤년일까요?)
		//    2023년 : 평년(2월 28일)
		//    2024년 : 윤년(2월 29일)
		
		int year = 2024 ;
		
		if((year %4 ==0) && (year % 100 !=0)||( year % 400 ==0)) {
			System.out.println("윤년입니다.");
		}		
		
		else {
			System.out.println("평년입니다.");
		}
		
		//연산의 우선 순위를 잘 정해야한다.
 
		//(7) 서기 1년 ~ 2023년까지(이하) 사이의 윤년의(번, 개) 출력
		
		
		
		int leapYear = 0;
		for(int i=1; i <= 2023; i++) {
			if((i %4 ==0) && (i % 100 !=0)||( i % 400 ==0)) {
				leapYear++;
			}
		}
		
		System.out.println("서기 1년 ~ 2023년까지(이하) 사이의 윤년은 " + leapYear + "번 입니다." );
		
	
		
		
		 
		
		
	}//main() close
}//Class
