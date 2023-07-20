package oop20230720;

public class MethodEx5 {

	public static void main(String[] args) {
		
		
      System.out.println(evenNumber(2));		
      System.out.println(evenNumber(-2));		
      System.out.println(evenNumber(0));		
      System.out.println(evenNumber(1));		
      System.out.println(evenNumber(-1));		
		

	}
	
	
public static int evenNumber(int n) {
	
	  return (n%2==0)?1:0;
}
	

}


//클래스명(파일명) : MethodEx5.java

//evenNumber 메서드 : 매개변수 정수 n을 전달 받아

//짝수인지 홀수인지를 검사하는 evenNumber 메서드를 정의하기

//(n이 짝수이면 1, 홀수이면 0을 return한다.)

//(출력결과는 자유롭게 만들어 보세요 ^^)