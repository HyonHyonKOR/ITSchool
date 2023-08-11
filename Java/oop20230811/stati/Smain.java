package oop20230811.stati;

public class Smain {
	public static void main(String[] args) {
		//과자 Class 만들기!
		//이름, 중량 , 가격 => 출력 기능까지!
		
		// 과자 이름? => 모름
		// 과자 무게? => 모름
		// 과제 가격? => 모름
		// 과자 생산자? => 김비버!
		//System.out.println(Snack.manufacurer);
		//System.out.println("----------");
		
		System.out.println(Snack.MANUFACTURER);
		System.out.println("----------");
		
		Snack.printTaste();
		
		Snack s1 = new Snack();
		s1.name = "허니버터칩";
		s1.weight = 150.3;
		s1.price = 3000;
		s1.printInfo();
		
		System.out.println("----------");
		Snack s2 = new Snack();
		s2.name = "프링글스";
		s2.weight = 200.1;
		s2.price = 3500;
		s2.printInfo();

		
		//s2.manufacurer = "김탁구";
		//s2.MANUFACTURER ="김탁구";
	}

}
