package oop20230713;

public class For4 {

	public static void main(String[] args) {

		
		
	for(int i=0; i<5; i++) {
		for(int k=0; k< 4-i; k++) {
			System.out.print(' ');	
		   }
		
		for(int j=0; j< i+1; j++) {
			System.out.print("*");	
		   }
		
		 System.out.println();
       }
	}                
}	
	
      /*  [결과]
          i(행)             (열)n($)                     j(*)   
          --------------------------------------------------- 
          0행  $$$$*(엔터)   (4회) 0123 (3-0)이하 (+1)     (1회) 0
          1행  &&&**(엔터)   (3회) 012  (3-1)이하 (+1)     (2회) 01
          2행  $$***(엔터)   (2회) 01   (3-2)이하 (+1)     (3회) 012
          3행  $****(엔터)   (1회) 0    (3-3)이하 (+1)     (4회) 0123
          4행  *****(엔터)   (0회)                       (5회) 01234
       
       */