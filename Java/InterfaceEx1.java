package oop20230802;

interface Animal {
	// 추상메서드만 존재
	abstract void kind();	// 추상메서드
	void breadth();			// 추상메서드, 메서드 앞의 abstract 생각 가능
}
//    클래스               인터페이스
class Elephant implements Animal {
	@Override
	public void kind() {
		System.out.println("포유류");		
	}
	@Override
	public void breadth() {
		System.out.println("허파로 호흡 중");		
	}
}
public class InterfaceEx1 {

	public static void main(String[] args) {
		// (에러) 인터페이스로는 new 객체(인스턴스) 생성 불가능
		// Animal ani = new Animal();
		
		Elephant el = new Elephant();
		el.kind();
		el.breadth();
		
		// 인터페이스는 다형성 가능!
		Animal ani = new Elephant();
		ani.kind();
		ani.breadth();
	}

}

// 인터페이스(interface)
// = 추상 메서드"만" 존재하는 인터페이스
// - 추상 클래스와 비슷, 추상 클래스 보다 추상화 정도가 높다.
// - (일반)필드와 (일반)메서드 갖지 못함
// - 인터페이스는 반드시 (하위)클래스에서 추상 메서드를 오버라이딩 해야만 한다.
// 추상클래스 : 추상메서드(1개 반드시) + (일반)메서드s
// 인터페이스 : 추상메서드만으로 구성되어 있음

