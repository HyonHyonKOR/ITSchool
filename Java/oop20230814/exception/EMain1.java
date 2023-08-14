package oop20230814.exception;

public class EMain1 {
	
	//error 
	//  한국어 - 번역 -> 영어
	//   사과          apple
	//   바나나         banana
	//   띱퀭          ???
	//Java의 문법에 안맞게 써서 컴파일이 불가능한 상태
	//개발자의 잘못!
	
	
	//warning
	//   지저분한 코드
	//   개발자 잘못!
	//   컴파일러가 컴파일은 가능하게 해줌 
	
	
	
	//Exception
	//   프로그램은 100% 완성!
	//   실행할 때 뭔가 외부적인 요인에 의해서 작동이 제대로 안되는 상황...
	//   개발자 잘못 아님
	//   개발자 입장 => 개발자가 상황을 예측해서 대책은 세워놓자...! 
	public static void main(String[] args) {
		//x : ? y : ? 입력받아서
		//더한 값, 뺀 값, 곱한 값, 나눈 값을 출력(정수로)
		
		int x  = 10;
		int y  = 0;
		
		System.out.println(x+y);
		System.out.println(x-y);
		System.out.println(x*y);
		//System.out.println(x/y);
		//일단 이 부분은 실행 - (내용)
		
		//x : 10, y : 0 => 68- 
		//x : 10, y: 1 =>
		//x : 2, y : 1 =>
		
		try {
			int d = x/y;
			System.out.println(d);
			int[] ar = {1,2,3};
			System.out.println(ar[x]);
		} catch(Exception e) {
			System.out.println("능지 떡락");
			e.printStackTrace();
		} 
		
	}
}
