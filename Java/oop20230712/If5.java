package oop20230712;

import java.util.Scanner;

public class If5 {

	public static void main(String[] args) {
		System.out.println("이용약관에 동의하십니까? (Y)es/N(o) => ");
		Scanner sc = new Scanner(System.in);
		String agree = sc.nextLine();
			
		if(agree.equals("Y") || agree.equals("y"))
			System.out.println("동의하였습니다.");
		else if	(agree.equals("N") || agree.equals("n"))
			System.out.println("동의하지 않았습니다.");
		else
			System.out.println("잘못 입력하셨습니다.");
		
		
		
		sc.close();
	}
}