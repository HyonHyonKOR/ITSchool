package oop20230710;

import java.util.Scanner;

public class Bmi {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		System.out.print("키(입력 예시:170)>" );
		double height = sc.nextDouble();
		
	    
		System.out.print("몸무게(입력 예시:70)>");
		double weight = sc.nextDouble(); 
		
		double bmi = (weight/((height/100.0)*(height/100.0)));
		
		System.out.printf("당신의 BMI는 %.2f입니다",bmi);
		
		sc.close();

	}
		
}
	
	


/*# Scanner 클래스를 사용하여, 산술연산하여 출력 해보기!
[3] 체질량 지수를 계산하는 프로그램
// 클래스명(파일명) : Bmi.java

---------------------------------------------

// 체질량 지수(體質量指數, Body Mass Index, BMI)는 인간의 비만도를 나타내는 지수로, 
// 체중과 키의 관계로 계산된다.
// 키가 t 미터, 체중이 w 킬로그램일 때, BMI는 다음과 같다. 
// (키의 단위가 센티미터가 아닌 미터임에 유의해야 한다.)
// BMI = w / t의2승 

---------------------------------------------

[결과][예]

=== 채질량 지수(BMI) ====

키(cm) : 170 (엔터)
몸무게(kg) : 70 (엔터)
당신의 BMI는 24.22 입니다. 
 * 
 * 
 */




