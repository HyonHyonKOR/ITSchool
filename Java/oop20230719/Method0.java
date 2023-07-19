package oop20230719;

public class Method0 {
	//클래스(class) : { 필드(field)s + 메서드(method)s}
	//멤버변수 : 필드, 속성
	//멤버함수 : 메서드, 기능, 함수(function)
	public static void main(String[] args) {  //메서드의 헤더
		//메서드의 바디(구현)
		//String 클래스
		//Math 클래스
		//Calendar 클래스
		
		System.out.println(Math.abs(-3));
		System.out.println(Math.max(5, 7));
		System.out.println(Math.min(5, 7));
		System.out.println((int)Math.pow(2, 3));
		System.out.println(Math.ceil(1.2));   //Double Return!!
		System.out.println(Math.floor(3.6));  //Double Return!!
		System.out.println(Math.round(9.5));
		
		
		
		//메소드 중첩
		System.out.println(Math.max(3, Math.max(5, 7)));
		
		
	} //main() end

}//Class end 
