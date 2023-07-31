package oop20230731;

class Animal{
	public void one() {}
	public final void two() {}
}
class Elephant extends Animal{
	@Override
	public void one() {}
	
	//@Override
	//public void two() {}
}


public class FinalTest {

	public static void main(String[] args) {
		// final 변수 : 변수의 상수화(초기화 필수)
		// final 메서드 : 더 이상 오버라이딩(overriding)할 수 없음
		// final 클래스 : 종단 클래스, 더 이상 클래스를 생성할 수 없음
	

	int a = 3;
	a = 5;
	System.out.println(a);
	
	final int b =7;
	//b = 10;
	//b++;
	System.out.println(b);
	
	Elephant e = new Elephant();
	e.one(); //Elephant method
	e.two(); //Animal method
  }
}