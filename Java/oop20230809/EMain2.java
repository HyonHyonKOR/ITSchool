package oop20230809;

//메소드의 재귀적 호출에 대하여
//메소드 속에서 메소드를 반복하여 호출하는 것.

//메소드를 호출한다는 것은 비교적 느린 작업에 속한다.
//재귀적 호출은 코테 볼때 알고리즘으로 내는 경우가 있으니 알면 좋다.

//등차수열 메소드 만들기 - 정수를 넣으면, 1부터 그 숫자까지 전부 더해주는 메소드
public class EMain2 {

	public static void main(String[] args) {
		
		System.out.println(add(5));
		System.out.println(factorial(6));
		System.out.println(fibonacci(9));
	}
	
	public static int add(int x) {
		return  (x == 1) ? 1 : ( x + add(x-1));
	}

	public static int factorial(int x) {
		return  (x == 1) ? 1 : ( x * factorial(x-1));
	}
	
	public static int fibonacci(int x) {
		return (x == 1 || x == 2) ? 1 : fibonacci(x-2) + fibonacci(x-1);
		
	}
	
		
}
