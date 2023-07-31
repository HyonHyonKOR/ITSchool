package oop20230731;

import java.util.Calendar;

public class StringEx {

	public static void main(String[] args) {
		
		String jumin = "8912301234567";
		
		StringBuilder sb = new StringBuilder(); 
		
		if(jumin.charAt(6)==('1')||jumin.charAt(6)==('2')) {
			sb.append(19).append(jumin);
		}
		else sb.append(20).append(jumin);
		
		int year = Integer.parseInt(sb.substring(0,4).toString());
		int month = Integer.parseInt(sb.substring(4,6).toString());
		int day = Integer.parseInt(sb.substring(6,8).toString());	
		
		System.out.printf("%d년%d월%d일\n",year,month,day);
		
		String sex = (jumin.charAt(6)==('1')||jumin.charAt(6)==('3'))? "남자":"여자";
		System.out.println("성별 : " + sex);
		
		Calendar now = Calendar.getInstance();
		
		int currentYear = now.get(Calendar.YEAR);
		int currentMonth = now.get(Calendar.MONTH)+1;
		int currentDay = now.get(Calendar.DAY_OF_MONTH);


		int korAge = currentYear-year;
		int worldAge = currentYear-year;
		
		
		if(currentMonth< month) worldAge--;
		else if(currentMonth==month && currentDay<day) worldAge--;
		
		System.out.println("(만)나이 : " + worldAge);
		System.out.println("(연)나이 : " + korAge);
		
		sb.delete(0,16);
	
		switch(year%12) {
		case 0: sb.append("원숭이"); break;
		case 1: sb.append("닭"); break;
		case 2: sb.append("개"); break;
		case 3: sb.append("돼지"); break;
		case 4: sb.append("쥐"); break;
		case 5: sb.append("소"); break;
		case 6: sb.append("호랑이"); break;
		case 7: sb.append("토끼"); break;
		case 8: sb.append("용"); break;
		case 9: sb.append("뱀"); break;
		case 10: sb.append("말"); break;
		case 11: sb.append("양"); break;
		
		}
		
		System.out.println("띠 : " + sb.toString());

	}

}
