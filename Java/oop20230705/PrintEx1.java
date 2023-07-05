package oop20230705;

public class PrintEx1 {

	
	public static void main(String[] args) {
		
		
		System.out.println("ABC");
		System.out.println("XYZ");
		System.out.println("A");
		System.out.println("가나다");
		System.out.println("홍길동");
		System.out.println("10");	//(결과)10  1+0이 출력
		System.out.println(10);     //(결과)10  10이 출력
		
		System.out.println(10+1);   //(결과)11  (+)산술덧셈연산자 cpu가 연산처리 후 값을 줌   산술=실행과정(수치형 자료)
		System.out.println("10+1"); //(결과)10+1 
		System.out.println("10"+1); //(결과)101 (+)문자열연결연산자. 실행과정이 아닌 번역하는 과정에서 연결함  연결=변역과정(비수치형 자료)
		
		System.out.println("나이 : 20+1세");
		System.out.println("나이 : " + 20+ 1 + "세");
		System.out.println("나이 : " + (20+1) + "세");
		
		int age =100;   //변수의 초기화(변수의 선언문; + 변수의 대입(할당))
		
		System.out.println("나이 : " +age + "세");
		age = age + 1;
		System.out.println("나이 : " +age + "세");
		
		System.out.println("이름 : " + "홍길동");
		System.out.println("나이 : " +age + "세");
		System.out.printf("나이: %d세\n",age);      //% 위치를 의미한다. f도 개행기능이 없기 때문에 \n을 입력한다. 
	    System.out.printf("이름 : %s, 나이: %d\n", "홍길동",age);   //형식 문자열은 인수의 갯수와 상관없이 무조건 " " 
	}
}