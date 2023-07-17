package oop20230713;

public class Chartest {
	public static void main(String[] args) {
		char a ='A';
		char b = 'A'+10;
		int  c = 'A'+10;
		int  d = 15;
	    
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		System.out.println(a+b); //자바의 기본연산(연산자를 이용한 행위) 시 int 기준이므로 char의 [값]은 복사 후 int 형으로 자동형변환 된다.
		System.out.println(~d);
		
  }
}	
