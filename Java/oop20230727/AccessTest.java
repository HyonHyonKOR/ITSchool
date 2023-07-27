package oop20230727;


class A{
	int a;
	public    int b;
	protected int c;
	private   int d;
	void show() {
		System.out.println(a);  
		System.out.println(b);
		System.out.println(c);
		System.out.println(d);
	}	
}//A end
class B extends A{  //외부 클래스 
	@Override
	void show() {
		System.out.println(a+10);
		System.out.println(b+10);
		System.out.println(c+10);
		//System.out.println(d+10);필드 외부 접근 불가능
	}
}
public class AccessTest { //외부 클래스
	
	public static void main(String[] args) {
		A objA = new A();
		objA.a = 10;
		System.out.println(objA.a);
		objA.b = 100;
		System.out.println(objA.b);
		objA.c = 1000;
		System.out.println(objA.c);
		//objA.d = 10000;
		//System.out.println(objA.d);
		
		
	}
}
