package oop20230731;

import java.util.Calendar;

public class CalendarTest {

	public static void main(String[] args) {
		//Calendar 클래스 : 날짜정보 관련 클래스
		
		//현재 시스템의 날짜 정보
		Calendar now = Calendar.getInstance();
		System.out.println(now);
		
		System.out.println(now.get(1));     //현재 년도
		System.out.println(now.get(2)+1);   //현재 월
		System.out.println(now.get(5));     //현재 일 
		
		System.out.println(now.get(Calendar.YEAR));     //현재 년도
		System.out.println(now.get(Calendar.MONTH)+1);   //현재 월
		System.out.println(now.get(Calendar.DAY_OF_MONTH));     //현재 일 
		
		System.out.println(now.get(Calendar.HOUR_OF_DAY));     //24시간
		
		System.out.println(now.get(Calendar.DAY_OF_WEEK)); //요일
		
		int week = now.get(Calendar.DAY_OF_WEEK);
		
		switch(week) {
		
		case 1: System.out.println("일"); break;
		case 2: System.out.println("월"); break;
		case 3: System.out.println("화"); break;
		case 4: System.out.println("수"); break;
		case 5: System.out.println("목"); break;
		case 6: System.out.println("금"); break;
		case 7: System.out.println("토"); break;
		
		}
	}

}
