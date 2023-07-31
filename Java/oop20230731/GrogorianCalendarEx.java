package oop20230731;

import java.util.*;

public class GrogorianCalendarEx {

	public static void main(String[] args) {
		
		GregorianCalendar cal = new GregorianCalendar();
		
		System.out.print(cal.get(Calendar.YEAR)+"년 ");
		System.out.print(cal.get(Calendar.MONTH)+1+ "월 ");
		System.out.print(cal.get(Calendar.DAY_OF_MONTH)+"일 ");
		System.out.print(cal.get(Calendar.HOUR_OF_DAY)+"시 ");
		System.out.print(cal.get(Calendar.MINUTE)+"분 ");
		System.out.println(cal.get(Calendar.SECOND)+"초");

	}

}
