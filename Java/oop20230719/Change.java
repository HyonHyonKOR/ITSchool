package oop20230719;

import java.util.Scanner;

public class Change {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int[] coinUnit = {500, 100, 50, 10 };
		System.out.print("금액을 투입해주세요: ");
		
		int input = sc.nextInt();
		int count = 0;
		
		int i=0;
		while(i<4) {
		 	 count = input/coinUnit[i];
	    	 System.out.printf("%d원 : %d개\n" , coinUnit[i],count); 
			 input = input % coinUnit[i];
			 i++;
		}
		
			 
	    sc.close();
	  }
		
    }


