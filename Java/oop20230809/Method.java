package oop20230809;

import java.util.Scanner;

//메소드 (Method)
//    관련있는 작업(기능)들을 묶고
//    필요할때마다 불러서(호출해서) 사용이 가능 0

// JDK (자바 개발키트) > JRE(자바 실행 환경)
// 실행 시 JRE가 OS(운영체제)에 맞춰서 > JVM(자바 가상머신)
//     => WORA (Write Once Read AnyWhere) - Java의 장점!!
// OS별로 프로그램을 만들지 않아도 됨

public class Method {
// public static 리턴타입 메소드명(파라미터,파라미터,...){
//	 //내용 
	 //return	
//	}
	
	//리턴타입 : 반환될 값의 자료형
	// 메소드 내에서 식이 완성이 되고, main으로 반환할 결과값에 대한 자료형
	// return이라는 것을 사용해서 반환을 할 것이고, 사용은 이따가...
	
	//메소드명: 말 그대로 이 메소드의 이름
	//   1.숫자로 시작하면 => 에러!
	//   2.특수문자, 띄어쓰기 => 에러!
	//   3.자바문자(예약어) => 에러!
	//     _으로 시작해서 에러를 막는 방법도 있음.
	//    int_int = 3;
	//   4. 메소드명을 봐도 무슨 기능인지 알 수 있게!
	//   5. 소문자로 시작
	//   6. 가독성을 위해서
	//   show me the money
	//      뱀체: show_me_the_money
	//      낙타체:showMeTheMoney
	//   7. 한글 X
	//  
	//      변수   메소드
	//      (명사)  (동사)
	
	//   파라미터(인자,parameter) : 메소드를 실행하는 데 필요한 재료
	//   필요한 갯수만큼 사용하되, 자료형에 맞춰서 사용해야함!!

    // 쉬는 날... 방에서 게임을 하고 있는데... -> 어머니가 심푸름 시켜요...
	public static void makeErrand() {
		System.out.println("아들 ~");
		System.out.println("돈 줄테니까 ~");
		System.out.println("슈퍼가서 ~");
		System.out.println("라면이랑 ~");
		System.out.println("참치사고 ~");
		System.out.println("남은 돈 가져와 ~");
		System.out.println("-------------------");
	}
	
	//실행 시 JVM이 main을 자동으로 호츌!
	//이 main도 사실은 메소드의 일종!
	//어머니가 돈을 주셨다! (돈 = 입력)
	public static int takeMoney() {
		try (Scanner k = new Scanner(System.in)) {
			System.out.print("엄마가 준 돈:  ");
			int money = k.nextInt();
			System.out.printf("엄마가 %d원을 주셨다!\n", money);
			System.out.println("------------");
			return money;
		}
	}
	
	//심부름 중에... (라면 : 3200, 참치 : 2170, 과자 : 1500 ) 
	//돈이 얼마 남는지 생각...
	public static void doErrand(int money) {
		int ramen = 3200;
		int tuna = 2170;
		int snack = 1500;
		// 계산하는 메소드
		// 계산이라는 작업을 하려면 '받아온 돈'이 필요!!
		// 그 돈은... 파라미터로 받아올 것!!
		System.out.printf("심부름하면 %d원이 남네...ㅎ\n", money - (ramen + tuna + snack));
		System.out.println("---------------");
	}
	
	//계산을 하고 잔돈을 어머니에게 주자
	public static int calculate(int money) {
		int ramen = 3200;
		int tuna = 2170;
		int snack = 1500;
	    int bbingddang = 3000;
	    
	    int restMoney = money - (ramen + tuna + snack + bbingddang);
	    return restMoney;
	}
	
	public static void main(String[] args) {
		makeErrand();
		int money = takeMoney();
		//System.out.println(money);
		doErrand(money);
		int restMoney = calculate(money);
		System.out.println(restMoney);
	}
	
	
}


  

