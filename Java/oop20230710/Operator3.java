package oop20230710;

public class Operator3 {
	public static void main(String[] args) {
		//관계 연산자:(결과)true,false
		//논리 연산자:(대상,결과)true,false
		//(NOT, 부정)논리 부정 연산자: !
		//(AND, 둘다, 그리고)논리 곱 연산자: ! :&&
		//(OR, 둘중하나라도, 또는)논리 합 연산자: ! :||
		
		System.out.println(!true);
		System.out.println(!false);
		System.out.println();
		
		//System.out.println(false&&false);
		//System.out.println(false&&true);
		System.out.println(true&&false);
		System.out.println(true&&true);
		System.out.println();
		
		System.out.println(false||false);
		System.out.println(false||true);
		//System.out.println(true||false);
		//System.out.println(true||true);
		System.out.println();
		
		int month = 7;
		int day = 10;
		System.out.println(month == 7);
		System.out.println(day == 4);
		System.out.println((month == 7) && (day == 4));
	}

}
