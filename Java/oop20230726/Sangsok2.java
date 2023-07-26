package oop20230726;

class Korea extends Object {
	//필드
	String name;
	//생성자
	public Korea() {                       //4
		System.out.println("Korea()---");             //5
	    this.name = name;
	}
	// 메서드
}

class Seoul extends Korea{
	
	public Seoul() {                       //2
		super();                                  //3
		System.out.println("Seoul()---");             //6
		
	}
	
}


public class Sangsok2 {

	public static void main(String[] args) {

		Seoul seoul = new Seoul();                    //1
		//자식객체 생성 --(동시에) --> (부모 기본->자식) 생성자 자동 호출  
	}

}
