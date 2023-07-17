package oop20230713;

public class Star {

	public static void main(String[] args) {

	//때려박기	
		
	for(int i=0; i<5; i++) {
		for(int k=0; k< 4-i; k++) {
			System.out.print(' ');	
		   }
		
		for(int j=0; j< i+1; j++) {
			System.out.print("*");	
		   }
		
		for(int j=0; j<i; j++) {
			System.out.print("*");
		 }
		   
		 System.out.println();
       }
	
	
	//2의 배수
	
	for(int i=0; i<5; i++) {
		for(int k=0; k< 4-i; k++) {
			System.out.print(' ');	
		   }
		
		for(int j=0; j<2*(i+1)-1; j++) {
			System.out.print("*");	
		   }
		
		System.out.println();   
	 }
	
   }	//main()
}//class	
	
	
/*	0  1
	1  2 
	2  3
	3  4
	
	              

	
      /*  [결과]
          i(행)             (열)n($)             j(*)   
          ---------------------------------------------  
          0행  $$$$*(엔터)   (4회) 0123 (3-0)이하 (+1)
          1행  &&&**(엔터)   (3회) 012  (3-1)이하 (+1)
          2행  $$***(엔터)   (2회) 01   (3-2)이하 (+1)  
          3행  &****(엔터)   (1회) 0    (3-3)이하 (+1)
       
       
       */

