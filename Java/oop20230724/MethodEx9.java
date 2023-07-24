package oop20230724;

public class MethodEx9 {
	public static int factorial(int n) {
		// 5! -> 5 * 4 * 3 * 2 * 1
		// n! -> (n-1) * (n-2) * ----- * 1
		if(n <= 1)   // 재귀호출 사용시, "반드시" 종료조건(판별)
			return 1;
		return n*factorial(n-1); 
	}
	//선언한 메소드를 return에 넣으면 재귀가 됨/ 메인호출->재귀호출->메인리턴
    //호출될때마다 코드 복사가 됨(반복문 효과)	

	public static void main(String[] args) {
	    // 팩토리얼 5! 을 계산하여 출력하는 프로그램
		// [결과] 5! = 120
		int num = 5;
		System.out.println(num + "i = " + factorial(5));
	}

}//class end
/* #:재귀호출 메서드(함수) (recursion function)
 *   : 자기 자신을 다시 호출하여 작업을 수행하는 함수
 * # 재귀호출 함수의 예 : 문자열 회문 판별, 퀵 정렬(quick sort)
 * # 재귀호출함수의 장단점
 * (+) 복잡한 알고리즘을 간단히 해결 가능(반복문 필요없음)
 * (+) 변수사용 최소화 가능
 * (-) 많은 메모리(memory stack) 을 사용 
 * (-) 함수 호출 -> 복귀를 위한 문맥 교환 (컨텍스트 스위칭)에 비용 발생
 * (해결) 꼬리 재귀(tail call recursion) = TCO(Tail Call Optimization)
 * 
 * 
 * 
 */
