package oop20230811.stati;

//변수는 왜 만드나요? 데이터 저장하려고 => 메모리 상의 공간
//          변수 : 데이터를 저장하는 공간(그릇)

//객체는 왜 만드나요? : 실생활스러운 변수(속성) 를 만들어서 알아보기 편하게 하려고
//           =>static이 없는 method 가지고 오려고!

public class Calculator {

	public static void add(int a, int b) {
		System.out.println(a+b);
	}
	
	public void add(int a, int b, int c) {
		System.out.println(a+b+c);
	}
}