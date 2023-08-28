package com.hyon.aug28.main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import com.hyon.aug28.reservation.Reservation;
import com.hyon.aug28.torikizoku.Torikizoku;

public class ConsoleScreen {
	
	  public static int showMenu() {
		  Scanner sc = new Scanner(System.in);
		  System.out.printf("%-23s%-20s%-20s\n", "1. 예약하기", "2. 매장 등록", "3. 전체 예약 확인");
		  System.out.printf("%-20s%-20s%-20s\n", "4. 전체 매장 조회", "5. 매장 찾기", "6. 예약 찾기");
		  System.out.printf("%-20s%-20s%-20s\n", "7. 예약 정보 수정", "8. 예약 취소", "9. 종료");
		  System.out.println();
		  System.out.print("번호 입력 : ");
		  return sc.nextInt();
	  }
	  
	  public static void printResult(String result) {
		  System.out.println(result);
	  }
	  
	  //1
	  public static Reservation ShowReserveEnrollMenu() throws ParseException {
		  Scanner sc = new Scanner(System.in);
		    
		    System.out.print("予約者名 :  ");
		    String name = sc.next();	  
		    System.out.print("予約時間(YYYY-MM-DD/HH:mm) : ");
		    String when = sc.next();	  
		    SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-DD/HH:mm");
		    Date when2 = sdf.parse(when);
		    System.out.print("携帯番号 :  ");
		    String phoneNum = sc.next();	  
		    System.out.print("支店名 :  ");
		    String location = sc.next();	 
		    
		    return new Reservation(0, name, when2, phoneNum, location);
		    
	  }
	  
	  //2
	  public static Torikizoku showTorikiEnrollMenu(){
		    Scanner sc = new Scanner(System.in);
		    
		    System.out.print("支店名 :  ");
		    String location = sc.next();	  
		    System.out.print("店長名 :  ");
		    String name = sc.next();	  
		    System.out.print("座席数 :  ");
		    int seat = sc.nextInt();
				  
		    return new Torikizoku(location, name, seat);	  
		     
		}
	  
	  //3
	  public static void showReserveListResultMenu(ArrayList<Reservation> rlist) {
		  SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd E a hh:mm");
		    for (Reservation r : rlist) {
				 System.out.printf("예약번호:%-3d" , r.getNo());
				 System.out.printf("예약자명:%-6s " , r.getName());
				 System.out.printf("예약시간: %-22s" , sdf.format(r.getWhen()));
				 System.out.printf("핸드폰 번호: %-15s" , r.getPhoneNum());
				 System.out.printf("지점명: %-6s\n", r.getLocation());
			}
	  }
	  
	  //4
	  public static void showTorikiListResultMenu(ArrayList<Torikizoku> tlist) {
		    for (Torikizoku t : tlist) {
				 System.out.printf("지점명:%-15s" , t.getLocation());
				 System.out.printf("지점잠명:%-15s " , t.getName());
				 System.out.printf("좌석수: %-3d\n" , t.getSeat());
			}
	  }
}
