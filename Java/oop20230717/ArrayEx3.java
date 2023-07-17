package oop20230717;

public class ArrayEx3 {

	public static void main(String[] args) {

	int[] num = { 1, 3, 5, -7, 9, -3, -8, -6, 11, 16, 8 };		
	int[] rank = new int[num.length];
	
	for(int i =0; i<num.length; i++) {
		rank[i] = 1;
	}
	
	for(int i=0; i<num.length; i++) {
		for(int j=0; j<rank.length; j++) {
			if(num[i] < num[j])
				rank[i]++;
		}
	}
	

	System.out.println("num[2]의 요소값 " + num[2]  + "의 등수는 "+ rank[2] + "등입니다.");
			
		
	}

}


