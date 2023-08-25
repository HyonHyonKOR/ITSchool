package com.hyon.aug252.main;
import java.util.Scanner;
//MVC의 C
////if (번호 == 1) {
//	consolescreen.예약하기 기능(입력);
//	dao.db관련 예약기능(insert)
//	결과보여주기(성공 or 실패);
//}


//1. 예약하기 (직접 입력, 날짜는 연-월-일/시:분)
//2. 매장 등록 (지점명, 지점장,좌석수)
//3. 전체 예약 확인 (날짜는 연-월-일 요일 오전/오후 시:분)
//4. 전체 매장 조회 (위치(좌석 수 - 사장님 이름)
//5. 매장 찾기 (최소 좌석 수 입력 => 좌석 수 이상의 매장 정보 출력)
//6. 예약 찾기 (예약자의 이름으로)
//7. 예약 정보 수정 (예약번호를 입력하면, 연락처를 변경)
//8. 예약 취소(예약번호로 취소)
//9. 종료


public class Controller {
	
     static Scanner sc = new Scanner(System.in);
	 static int menunum;
	
	public static void Activate() {
		while(true) {
			System.out.println("원하시는 메뉴 번호를 선택하세요");
			System.out.println();
			System.out.printf("%-23s%-20s%-20s\n", "1. 예약하기", "2. 매장 등록", "3. 전체 예약 확인");
			System.out.printf("%-20s%-20s%-20s\n", "4. 전체 매장 조회", "5. 매장 찾기", "6. 예약 찾기");
			System.out.printf("%-20s%-20s%-20s\n", "7. 예약 정보 수정", "8. 예약 취소", "9. 종료");
			System.out.println();
			System.out.print("번호 입력 : ");
			int menunum = sc.nextInt();
			
			if(menunum==9) {
				System.out.println("시스템을 종료하겠습니다.");
				System.exit(0);
			}
		}
	}
}