package oop20230801.crud;

import java.util.Scanner;

public class CrudEx {
	public static void main(String[] args) {
		//menu
		Scanner sc = new Scanner(System.in);
		int chNum;
		
		//하위 메뉴 처리를 위한 인스턴스 생성(원래는 DAO를 먼저 만든다)
		DaoClass dao = new DaoClass();
		
		while(true) {
			System.out.println("###  실행 하실 작업의 번호를 입력하시오 ###");
			System.out.println("# 1. INSERT - 추가               #");
			System.out.println("# 2. DELETE - 삭제               #");
			System.out.println("# 3. SEARCH - 검색               #");
			System.out.println("# 4. UPDATE - 수정               #");			
			System.out.println("# 5. EXIT - 프로그램 종료           #");
			System.out.println("#################################");
			System.out.print(">>>");
			
			chNum = sc.nextInt();
			
			
			switch(chNum) {
			case 1: 
			    dao.insert(); break;
			case 2:
				dao.delete(); break;
			case 3:	
				dao.search(); break;
			case 4:
				dao.update(); break;
			case 5: 
				System.out.println("프로그램을 종료합니다. 이용해주셔서 감사합니다.");
				System.exit(0);
			}//switch end
		  	
		}//while end
	  
	}//main()end

}//class end
