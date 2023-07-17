package oop20230717;

public class Break2 {

	public static void main(String[] args) {
		//[문제] 무한 while문
		// 3배수의 누적 합계(hap)가 100이 넘어가면 (초과)
		// 3부터 어디까지 더해야하는지 구하세요.
		//(예) 3 + 6 + 9+ 12 +15 ....su ==> 결과 > 100
		
		
		int i=3;
		int hap = 0;
		while(true) {
			hap += i;                //(1) 누적 합계
			if(hap>100) break;       //(2) 종료 합계
			i += 3;                  //(3) 다음항 분비
		}//while end
		System.out.println("3+ 6 + 9 + 12 + 15 ... +" +  i + " = " + hap);
		
		hap = hap-i;
		i = i-3;
		System.out.println("3+ 6 + 9 + 12 + 15 ... +" +  i + " = " + hap);
	}
}