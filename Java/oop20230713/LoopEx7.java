package oop20230713;

public class LoopEx7 {
	
	public static void main(String[] args) {
		
		 int sum0 =1;   
		 int sum1 =1;
		 int sum2 =2;
		 
		 for(int i=0;i<10;i++) {
			  if(i==0) {
			  System.out.print(sum0+ " ");
			  }
			  
			  else {       
			  System.out.print(sum1+ " ");
			  sum2 = sum0+ sum1;          
			  sum0 = sum1;
			  sum1 = sum2;               
			                 
			  }
		 	}
	}//main	                                                         	
}//Class                                                

                                             
                    
