package oop20230719;
/*
a0                          
a1 a0                   *
a2 a1 a0                **
a3 a2 a1 a0             ***
a4 a3 a2 a1 a0          **** 
a5 a4 a3 a2 a1 a0       *****


*/

public class LottoEx {

	public static void main(String[] args) {
		
		int[] lotto = new int[6];     	
		
		for(int i=0; i<6; i++) {
			
			lotto[i] = (int)(Math.random()*45)+1; 
			
			for(int j=0; j<i; j++) {
			       
			  if(lotto[i]==lotto[j]) {            
				  i--;
				  break;	
			  }
			}
		}
		
			
		for(int number: lotto) {	                           
			System.out.printf("[%d]",number);
		}
		
   }	

}


 