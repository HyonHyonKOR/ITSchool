package oop20230811.stati;


public class SMain2 {
	public static void main(String[] args) {
		Calculator c= new Calculator();
		//c.add(10, 20);      //static O
		c.add(10, 20, 30);    //static X
	   ////////////////////////////////
	    Calculator.add(10, 20);  //static O  
	   //Calculator.add(10, 20, 30);  //static x  
	    
	    
	    //Math
	    //객체를 만들지 않고 사용
	    System.out.println(Math.PI);
	    double s = Math.sqrt(10);
	    System.out.println(s);
	}
}
