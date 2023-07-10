package oop20230710;

public class Operator4 {
	public static void main(String[] args) {
		//전위 증가/감소 연산자 ++a/--a(앞,먼저)
		//후위 증가/감소 연산자 a++/a++(뒤,나중)
		
		//단독인 경우는 순서는 상관없다.
		
	    int a = 10;
	    int b = 0; 
	    b= ++a;
	    
	    System.out.println("a: "+ a);
	    System.out.println("b: "+ b);
	    
	    a = 10;
	    b = 0; 
	    b= a++;
	    
	    System.out.println("a: "+ a);
	    System.out.println("b: "+ b);
	    
	   
	
	}
}
