package oop20230814.InputOutput;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.StringTokenizer;

public class TestMain2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("이름/생년월일(yyyy.MM.dd)/국어점수/수학점수/영어점수");
		String s = sc.next();
		System.out.println(s);
		
		StringTokenizer st = new StringTokenizer(s,"/");
		System.out.printf("이름 : %s\n" , st.nextToken());
		
		try {
			String bd = st.nextToken();
			SimpleDateFormat sdf= new SimpleDateFormat("yyyy.MM.dd");
			Date birthday = sdf.parse(bd);
			System.out.println(birthday);
			
			SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy/MM/dd E");
			String birthdatStr = sdf2.format(birthday);
			System.out.printf("생일 : %s\n", birthdatStr);
			
			SimpleDateFormat  yearFmt = new SimpleDateFormat("yyyy");
			String nowYr = yearFmt.format(new Date());
			int ny = Integer.parseInt(nowYr);
			
			String birthdaytYr = yearFmt.format(birthday);
			int by = Integer.parseInt(birthdaytYr);
			
			int age = ny -by;
			System.out.printf("나이 : %d살\n",age);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		sc.close();
	}

}
