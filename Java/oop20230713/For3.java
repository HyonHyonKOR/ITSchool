package oop20230713;

public class For3 {
	public static void main(String[] args) {
				
		// 선생님 

		
		
		for(int i=0; i<5 ;i++) {
			
			 for(int j=0; j<i+1; j++) {
				System.out.print("*");
			 }
		     
			System.out.println();	
		 }

		
		
		for(int i=0; i<5 ;i++) {
			
			 for(int j=0; j<5-i; j++) {
				System.out.print("*");
			 }
		     
			System.out.println();	
		 }
		
		
		// 나 
		
		for(int i=0; i<5 ;i++) {
			
			 for(int j=5; j>i; j--) {
				System.out.print("*");
			 }
		     
			System.out.println();	
		 }
		
		
		
		
		
		
		
		
	}//main() end
}//Class end

/*

          i행                j열
//*****   0  5 4 3 2 1      0 1 2 3 4 (4-0) 이하   +1                       
//****    1  5 4 3 2        0 1 2 3   (4-1) 이하   +1
//***     2  5 4 3          0 1 2     (4-2) 이하   +1
//**      3  5 4            0 1       (4-3) 이하   +1
//*       4  5              0         (4-4) 이하   +1


          i행                j열
//***** 5  0  0 1 2 3 4 (4-0) 이하   +1                       
//****  4  1  0 1 2 3   (4-1) 이하   +1
//***   3  2  0 1 2     (4-2) 이하   +1
//**    2  3  0 1       (4-3) 이하   +1
//*     1  4  0         (4-4) 이하   +1





//*       0  0             
//**      1  0 1
//***     2  0 1 2
//****    3  0 1 2 3
//*****   4  0 1 2 3 4



*/