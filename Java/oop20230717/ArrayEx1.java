package oop20230717;

public class ArrayEx1 {

	public static void main(String[] args) {

	int count = 0;
	int[] num = { 1, 3, 5, -7, 9, -3, -8, -6, 11, 16, 8 };	
	for(int a : num) {
		if(a<0) count++;
	}
	
	System.out.println("음수의 수 : " + count);
	}

}

