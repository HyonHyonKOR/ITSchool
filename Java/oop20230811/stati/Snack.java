package oop20230811.stati;


public class Snack {
	String name;
	double weight;
	int price;
	
	// 이 세상에 존재하는 모든 과자를 김비버가 만든다고 하면...?
	//               이 때 사용하는게 **static 멤버변수!
	//                  -객체가 없어도 쓸 수 있는 정보
	//                       => 클래스명.xxx로 사용
	//                  - 객체들의 공통 속성 
	//                   => 객체를 여러개 찍어내도 static 멤버는 하나만
	//                   => 메모리 절약 
	//                  - static 영역의 데이터는 프로그램의 시작부터 종료가 될때까지
	//                        메모리에 남아있게 됨 
	//                  - 무분별하게 많이 사용하다 보면 메모리가 부족해질수 있음
	
	//static String manufacurer = "김비버";
	
	//static final 멤버변수
	//    수정 불가 => 상수화!(값을 변경하지 않겠다)
	//    static final 자료형 변수명 = 값;
	//    변수명은 대문자로 쓰는 문화가 있음
	static final String MANUFACTURER = "김비버";
	
	
	
	public void printInfo() {
		//멤버변수 : 객체의 속성 => (객체 속성으로 표현)
		//                 => this : 이 객체를 표현
	
		System.out.printf("이름 : %s\n", this.name);
		System.out.printf("무게 : %.2fg\n",weight);
		System.out.printf("가격 : %d원\n" , this.price);
		
		//System.out.printf("생산자 : %s\n" , manufacurer);
		System.out.printf("생산자 : %s\n" , MANUFACTURER);
	
	}
	
	//static 메소드
	//       메모리가 절약됨 => 암튼 됨...!
	//       객체가 없어도 사용가능하다
	//       static이 아닌 다른 멤버변수에 접근 불가함!!
	public static void printTaste() {
		System.out.println(MANUFACTURER);
		//System.out.println(name);  // =>static이 아닌 멤버 변수라 에러 발생
		System.out.println("크 ~ JMT!");
		System.out.println("===================");
	}
  }
