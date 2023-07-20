package oop20230720;

public class Method7 {
	
	public static void swapCBV(int a, int b)
	{
	int temp;
	temp = a;
	a = b;
	b = temp;
	
	}
	
	
	public static void swapCBR(int[] n)
	{
	int temp;                                                     
	temp = n[0]; 
	n[0] = n[1];
	n[1] = temp;
	
	}
	
	
	public static void main(String[] args) {
		//두 변수의 교환
		int a = 30;
		int b = 50;
		
		System.out.println("=== Call by Value : 교환 실패 ==="); 
		System.out.println("교환 전 : " + a + " " + b); 
		swapCBV(30, 50); //call by value
		System.out.println("교환 후 : " + a + " " + b);
		
		int[] n = {30,50};
		System.out.println("=== Call by Value : 교환 성공 ==="); 
		System.out.println("교환 전 : " + n[0] + " " + n[1]);
		swapCBR(n);
		System.out.println("교환 후 : " + n[0] + " " + n[1]);
		
	}//main

}//Class end 
