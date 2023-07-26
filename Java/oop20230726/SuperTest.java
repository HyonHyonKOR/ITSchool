package oop20230726;

class Father extends Object{
	String name = "아버지";
	int age = 20;
	
	public Father() {System.out.println("Father()---");}
	public Father(String name, int age) {
		this.name = name;
		this.age = age;
	}
}

class Son extends Father{  //부모의 필드와 메소드를 100% 다 받는다 
	public Son() {System.out.println("Son()---");}
	
	public void disp() {
		System.out.println(name);
		System.out.println(age);
	}
	
}

class Daughter extends Father{
	String address;

	public Daughter() {}
	
	public Daughter(String name, int age, String address) { //자식 매개변수 생성자
		//super();     
		//[기본] 부모 기본 생성자 자동호출
		super(name,age);        //[기본] 부모의 매개변수를 갖는 생성자를 자동호출 
		//super.name = name;
		//super.age = age;
		this.address = address;
	}
	
	public void show() {
		System.out.println(name + " " + age + " " + address);
	}
}


public class SuperTest {

	public static void main(String[] args) {
		//      자식객체 생성 --(동시에) --> (부모"기본"->자식"기본") 생성자 자동 호출
		Son son = new Son();
		son.disp();
		
		System.out.println();
		// [원하는 상황] 자식객체 생성 --(동시에) --> (부모"매개변수"->자식"매개변수") 생성자 자동호출
		//      [기본] 자식객체 생성 --(동시에) --> (부모"기본"->자식"매개변수") 생성자 자동 호출
		Daughter jane = new Daughter("김제인",25,"관철동");
		jane.show();
	}
}

//super :   부모의 멤버변수
//super() : 부모의 생성자함수를 호출
//this    : 자신의 멤버변수 접근 (예) this.name = "홍길동";
//this()  : 자신의 생성자함수를 호출