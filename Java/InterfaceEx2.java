package oop20230802;
class Unit {
	int currentJP;	// 유닛의 체력
	int x;			// 유닉의 위치(x좌표)
	int y;			// 유닉의 위치(y좌표)
} // class end
interface Moveable {
	// 지정된 위치(x, y)로 이동하는 기능의 메서드
	abstract void move(int x, int y);
} // interface end
interface Attackable {
	abstract void attack(Unit u);
} // interface end
interface Fightable extends Moveable, Attackable { 
	// 인터페이스는 다중 상속(extends)이(도) 가능하다.
} // interface end
class Fight extends Unit implements Fightable {
	@Override
	public void move(int x, int y) {
		// TODO Auto-generated method stub		
	}
	@Override
	public void attack(Unit u) {
		// TODO Auto-generated method stub		
	}	
} // class end

public class InterfaceEx2 {

	public static void main(String[] args) {
		// Java에서는 (클래스 간)다중상속 불가능하다.
		// 인터페이스와 클래스 간의 상속 및 구현
		// Java에서는 "다중상속"을 인터페이스(간 상속으로) 구현한다.
		// # 인터페이스와 다중상속
		// 인터페이스 : 구현 implements
		// 추상클래스 : 상속 extends
		// Java는 다중상속 불가능하다.
		//        다중구현은 가능하다.
	}

}
