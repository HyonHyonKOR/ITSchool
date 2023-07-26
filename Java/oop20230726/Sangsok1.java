package oop20230726;

class AA{ //부모클래스//super/기본(base)클래스
	//필드                   
	//생성자
	//메서드
	public void one() {
		System.out.println("one()---");
	}
	public void two() {
		System.out.println("two()---");
	}
} // class AA end

// (상속)
// class 자식클래스명 extends 부모클래스명
class BB extends AA { //자식/하위/sub클래스/파생(derived)클래스
/*	public void one() {
		System.out.println("one()---");
	}
	public void two() {
		System.out.println("two()---");
	}
	*/
	public void three() {
		System.out.println("three()---");
	}
}// class BB end 

class CC extends BB{}
class DD extends AA{}

//java에서는 클래스는 단일상속만 가능


public class Sangsok1 {

	public static void main(String[] args) {
		AA aa = new AA(); //부모 객체생성 --> 생성자 자동호출
		aa.one();
		aa.two();
//		aa.three();
		
		BB bb = new BB(); //자식 객체생성 --> 생성자 자동호출
		bb.one();
		bb.two();
		bb.three();
		
		CC cc = new CC(); //자식 객체생성 --> 생성자 자동호출
		cc.one();
		cc.two();
		cc.three();
		
		DD dd = new DD(); //자식 객체생성 --> 생성자 자동호출
		dd.one();
		dd.two();
	}

}
