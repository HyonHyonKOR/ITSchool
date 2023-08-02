package oop20230802;

abstract class Parent{
	String name = "parent";
	
	abstract void view(); //abstract method
	void line() {} //default method 
}

class Son extends Parent{
	
	@Override
	void view() {
		System.out.println("Son");
	}
}


public class AbstractEx1 {

	public static void main(String[] args) {
	    //추상(부모) 클래스를 상속 받은 자식 클래스만 객체 생성 가능!
	    //추상 (부모) 클래스는 new 객체(인스턴스) 생성 불가능!
	
		
	    Son son = new Son();
	    son.view();
		
	
	}

}
