package oop20230717;

public class ArrayEx2 {

	public static void main(String[] args) {

	int sum = 0;
	int[] num = { 1, 3, 5, -7, 9, -3, -8, -6, 11, 16, 8 };	
		
	for(int a : num) {
	  if(a>0 && a%2==0) sum+=a; 
	}
		
	System.out.println("짝수의 합 : " + sum);	
		
  }

}

