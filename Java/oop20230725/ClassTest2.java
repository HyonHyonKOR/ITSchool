package oop20230725;

class TestInit {    //클래스{private 필드 + 생성자 + public 메서드(setter,getter)}
	private int a;
	private double b;
	public int getA() {return a;}
	public void setA(int a) {this.a=a;}
	public double getB() {return b;}
	public void setB(double b) {this.b=b;}
	public void set(int a,double b) {
		this.a = a;
		this.b = b;
	}	
	public void show() {System.out.println("a:" +a+ ",b:" +b);}
	public void init() { //초기화 설정 기능
		a =0;
		b =0.0;
	}
} //TestInit class end


public class ClassTest2 {

	public static void main(String[] args) {
	int a = 10; // 초기화
	a = 70;	    // 대입(설정,set)
	a = 100;  
	System.out.println(a);
	
	TestInit t1 = new TestInit();
	t1.init();
	t1.show();
	t1.set(10, 3.14);
	t1.show();

	}

}
