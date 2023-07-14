package oop20230712;

import java.util.Scanner;

public class SelectionEx6 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("ID를 입력해주세요 : ");
		String id = sc.next();
		System.out.println("비밀번호를 입력해주세요 : ");
		String pw= sc.next();
		
		
		if(id.equals("hong")&&pw.equals("1234")){
			System.out.println("로그인되었습니다.");
		}else {
			System.out.println("아이디나 비밀번호가 틀렸습니다.");
		}
	
	sc.close();

	}

}
