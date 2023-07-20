package oop20230720;

public class MethodEx1 { 
	public static void main(String[] args) {
	
	   leapYear();
		
	}
	
	
	public static void leapYear() {
	int count = 0; 
	for(int year =1; year <= 2023; year++){
	 if(year%4 == 0 && year%100 != 0 || year%400==0) {
			    count++;
			   }
	    }
	 System.out.println(count); 
	}	
}
