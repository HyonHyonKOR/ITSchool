package oop20230720;

public class Method6 {
	//(1) 두 정수 초기화 -> (2) 덧셈 -> (3) 출력
	//add3 기능 : (1) 두 정수를 초기화하고 (2) 덧셈 (결과 반환) / main 기능: 출력
	
	public static int add3() {
		//(1)두 정수 초기화
	    int num1 = 20;	
	    int num2 = 30;	
	    int num3;	
		//(2)덧셈
	    num3= num1+num2;
	    return num3;
	}
	
	
	
	public static void main(String[] args) {
	
		System.out.println(add3());
		
		
	}//main
	
}//Class
