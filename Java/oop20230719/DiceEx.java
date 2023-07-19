package oop20230719;

public class DiceEx {

	public static void main(String[] args) {
		
		int[] d = new int[6];                        
		
		for(int i=0; i<20; i++) {
		 int number = (int)(Math.random()*6)+1;
			
		  switch(number) {
		  case 1: d[0]++; break; 
		  case 2: d[1]++; break;
		  case 3: d[2]++; break;		  
		  case 4: d[3]++; break;
		  case 5: d[4]++; break;	  
		  case 6: d[5]++; break;	  
		 
      	  }
		}
	
		for(int i=0; i<6; i++) {
			System.out.printf("눈금%d: %d회\n",i+1,d[i]);
		
		}
	
	  }	
		  	           
  }

