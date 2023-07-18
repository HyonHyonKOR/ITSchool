package oop20230718;

public class Array10 {

		   public static void main(String[] args) {
		 
		  
		 
		   // (1) 選択ソート
		   int[] a = new int[] {11,23,7,9,14};
		   System.out.println("====整列前====");
		   
		   for(int idx: a ){
		     System.out.printf("%d ", idx);
		   }
		    System.out.println();
		   
		   
		   int loop = a.length - 1 ;
		   
		   for(int i=0; i< loop; i++){
		        for(int j=i+1; j< a.length; j++)
			     if(a[i] > a[j]){
			     int temp = a[i];
			     a[i] = a[j]; 
			     a[j] = temp;
			     }
		        
		      System.out.printf("===%d回転後===\n", i+1);   
			     
			  for(int k=0; k<a.length; k++ ){
			  
		      System.out.printf("%d ", a[k]);
		      }     
		         
			  System.out.println();
		      } 
		   }
		}