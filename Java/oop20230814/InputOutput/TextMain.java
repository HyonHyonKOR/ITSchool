package oop20230814.InputOutput;

import java.util.*;

public class TextMain {
	//학생의 (이름/생년월일(yyyy.MM.dd)/국어/수학/영어)를 입력받아서
	//학생의 나이,총점,평균 값을 출력
	//StringTokenizer
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("이름/생년월일(yyyy.MM.dd)/국어점수/수학점수/영어점수");
		System.out.println();
		String input = sc.next();
		
		StringTokenizer st = new StringTokenizer(input,"/");
		int total = 0;
		
		//이름 출력
		System.out.print("이름:" + st.nextToken());
		
		//나이 출력 => StringTokenizer는 하나의 delimiter만 나누기 때문에 한 번 더 StringTokenizer 객체를 생성해서 나눔
		String birth = st.nextToken();
		StringTokenizer st2 = new StringTokenizer(birth,".");
		int inputyear = Integer.parseInt(st2.nextToken());
		int inputmonth = Integer.parseInt(st2.nextToken());		
		int inputday = Integer.parseInt(st2.nextToken());
		
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH)+1;
		int day = cal.get(Calendar.DAY_OF_MONTH);
		
		//나이의 정의 => 현재 기준으로 달이 작으면 이미 생일이 지남/ 크면 아직 생일이 안옴(-1), 날짜로 같은 원리 
		if(inputmonth-month >0 || inputmonth == month && inputday > day) {
			System.out.printf(" 나이:%d세", year-inputyear-1); 
		    }
		else {
			System.out.printf(" 나이:%d세", year-inputyear); 
		}
		
		//점수 입력
		while(st.hasMoreTokens()) {
		   total += Integer.parseInt(st.nextToken());
		}

		//점수 출력
		System.out.print(" 총점:" + total +"점");
		System.out.printf(" 평균:%.2f점",(double)total/3);
	    
		sc.close();
	}

}