package oop20230705;

public class VariableEx1 {

	public static void main(String[] args) {
		// 변수(variable):memory, 상수를 저장하는 공간
		// 상수(constant):항상 같은 값, value
		int age;      //변수의 선언문; (문법) 자료형 변수명;
		age =20;      //변수의 대입문; (문법) 변수명 = 값;
		              //변수의 배정문; 
		              //변수의 할당문;
		age = age + 1;// = 대입연산자
		System.out.println(age);

	}  //main() end

}  //class end

/*
 * 변수의 대입 
 * 주소 = 값 
 * age = 20;
 * 
 * 변수의 4요소
 * 
 * 1) 주소(address)
 * 2) 자료형(type)
 * 3) 이름(name)
 *    age = 20;
 * 4) 값(value)
 * 
 * ===상수(constant): 항상 같은 값,value
 * 정수형 상수 : +1,-1,+5,-7  ~~
 * 실수형 상수 : +3.14,-12.5  ~~
 *  -단정도형 실수 : +3.14f (4byte)
 *  -배정도형 실수 : +3.14  (8byte)
 * 문자형 상수 : 'a','b','c','1','+'  --
 * 문자열형 상수 : "Hello","java","화이팅","A"  ~~
 * 논리형 상수 :true,false 
 * 
 */
