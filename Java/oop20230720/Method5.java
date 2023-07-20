package oop20230720;

public class Method5 {
	 //(1)두 정수 초기화 (2) 덧셈 (3) 출력             
	 //[callee]                                       [caller]
	 // add1 기능 : 없음                                / main 기능: 두 정수를 초기화하고 덧셈 후 출력
	 // add2 기능 : 두 정수를 초기화하고 덧셈 후 출력           / main 기능: 없음
	 // add3 기능 : 두 정수를 초기화하고 덧셈(결과 반환)         / main 기능: 출력
	 // add4 기능 : (두 정수를 전달 받아서) 덧셈 후 출력        / main 기능: 없음
	
	 // add5 기능 : (두 정수를 전달 받아서) 덧셈(결과 반환)/     / main 기능: 출력 
	 //               가인수 int num1, int num2 = 실인수 20, 30; 
	public static int add(int num1,int num2) { //변수 num1, num2 생성: 지역변수
		return num1 + num2;
	}
	  //num1,num2 소멸(제거)
	public static void main(String[] args) {
		//선언, 초기화, 입력
		int num1 = 20;
		int num2 = 30;
		int num3;
		
		//처리
		num3 = add(num1,num2); //add(20,30) <- 실인수, Call by Value
		//출력
		System.out.println(num1 + "+" + num2 + "=" + num3);
		
	}//main

}

/*  class end 
 * ===함수(메서드) 호출 ===
 * 
 * [Caller]          [Callee]
 * 
 *      실매개변수               가매개변수
 *
 *      실인수                  가인수
 *  main(){                   add(int x, int y){
 *      
 *   add(10,20); ----[CALL]--->      
 *                <--[RETURN]--   return 문;
 *  }                            }
 *  
 *                            
 *  ===Java 매개변수 전달 기법
 *  １. Call by Value (값에 의한 전달)
 *         : 값 , 복사, 원본 -> 사본, return 문; (1개만 결과 반환)
 *  
 *  2. Call by Reference (참조에 의한 전달)                               
 *         : 주소, 원본값에 반영(처리)                         
 */

