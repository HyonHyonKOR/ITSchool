package oop20230717;

import java.util.Arrays;

public class Array3 {

	public static void main(String[] args) {
		//프로그램 기본 알고리즘: 최솟값(min)과 최댓값(max)
		//               
		//           0 1 2 3 4 
		int[] num = {7,3,1,8,6};
		     
		
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		
		//최소값 
		for(int i = 0; i <num.length; i++) {
			if(min > num[i]) 
		       min = num[i];                 //현재의 최솟값 변경(갱신)
		}
		
		//최대값
		
		for(int i = 0; i <num.length; i++) {
			if(max < num[i]) 
			   max = num[i];                 //현재의 최솟값 변경(갱신)
		}
		
		System.out.println("최솟값:" + min);
		System.out.println("최대값:" + max);
		
		
		Arrays.sort(num);
		
		min = num[0];
		max = num[num.length-1];
		
		System.out.println("최솟값:" + min);
		System.out.println("최대값:" + max);
		
	}

}
