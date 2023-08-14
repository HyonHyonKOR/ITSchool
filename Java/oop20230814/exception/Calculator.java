package oop20230814.exception;

public class Calculator {
	//1. 여기서 아예 끝장을 보자!! : try - catch - finally
	public static int getGramPerPrice(int price, int weight) {
		try {
			int answer = price/weight;
			return answer;
		}catch(ArithmeticException e) {
			System.out.println("으엑");
			return -9999;
		}finally {
			System.out.println("zzzz");
		}
     }
	
	
	
	//2. 미루기 : throws => try보다 더 많이 사용하게 될 것
	// divide2를 실행하다가 Exception이 발생하면 
	// divide2를 호출한 쪽에서 해결해라! 
	public static int getGramPerPrice2(int price, int weight) throws Exception {
		return price/weight;
	}
}