package oop20230802;

import java.util.Scanner;

public class AbstractTest1 {
	
	public static void main(String[] args) {
		abstest.startmenu();
    }
	
static Scanner sc = new Scanner(System.in);
private static final AbstractTest1 abstest = new AbstractTest1();

private AbstractTest1() {}

public static AbstractTest1 getInstance() {
	return abstest;
}

public void startmenu() {
	while(true) {
	System.out.print("고용형태를 선택하시오(P: 고용직, T: 임시직) >" );
	String menu = sc.nextLine();

	if(menu.equalsIgnoreCase("P")) {
		Permanert p = new Permanert();
		System.out.print("이름 : " );
		p.setName(sc.nextLine());
		System.out.println();
		System.out.print("기본급여 : " );
		p.setBasicPay(sc.nextInt());
		sc.nextLine();
		System.out.println();
		System.out.print("보너스 : " );
		p.setBonus(sc.nextInt());
		sc.nextLine();
		System.out.println();
		System.out.println("-----------------");
		System.out.println();
		System.out.println("고용형태 : 고용직(정규직)");
		System.out.println();
		System.out.println("사원 : " + p.getName());
		System.out.println();
		System.out.println("급여 : " + p.getPay());
		
		System.exit(0);
		
	}
	else if(menu.equalsIgnoreCase("T")){
		Temporary p = new Temporary();
		System.out.print("이름 : " );
		p.setName(sc.nextLine());
		System.out.println();
		System.out.print("시간당급여 : " );
		p.setTimePay(sc.nextInt());
		sc.nextLine();
		System.out.println();
		System.out.print("시간 : " );
		p.setTime(sc.nextInt());
		sc.nextLine();
		System.out.println();
		System.out.println("-----------------");
		System.out.println();
		System.out.println("고용형태 : 임시직(아르바이트)");
		System.out.println();
		System.out.println("사원 : " + p.getName());
		System.out.println();
		System.out.println("급여 : " + p.getPay());
		
		System.exit(0);
		
	}
	else {
	  System.out.println("다시 입력해주세요");
	  continue;
	}
  }
}	
	
}

/*
고용형태를 선택하시오(P: 고용직, T: 임시직) > P (엔터)

이름 : 홍길동 (엔터)

기본급여 : 2500000 (엔터)

보너스 : 500000 (엔터)

---------------------

고용형태 : 고용직(정규직)

사원 : 홍길동

급여 : 3000000

​

// [실행][예2]

고용형태를 선택하시오(P: 고용직, T: 임시직) > T

이름 : 홍길순 (엔터)

시간당급여 : 20000 (엔터)

근무시간: 20 (엔터)

---------------------

고용형태 : 임시직(아르바이트)

사원 : 홍길순

급여 : 400000

​
*/