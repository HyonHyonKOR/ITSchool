package oop20230711;

public class Operator9 {

	public static void main(String[] args) {
		//정수 연산: %,&,^,|,~,<<,>>,>>>
		//비트 shift 연산자: <<, >>,>>>
		System.out.println(14<<2); //56
		System.out.println(14>>2); //56
		System.out.println(14>>>2); //56
		// <<: padding bit는 무조건 0
		// >>: padding bit는 MSB에 맞춤(양수면 0, 음수면 1)
		// >>>: padding bit는 무조건 0
		
		System.out.println(-4>>2);
		System.out.println(-4>>>2);
	}

}
