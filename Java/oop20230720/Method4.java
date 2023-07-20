package oop20230720;

public class Method4 {

	public static void main(String[] args) {
		int num1 = 20;
		int num2 = 30;
		int num3 = num1 + num2;
		System.out.println((num1 + num2));
		System.out.println(num3);
		System.out.println(add(num1,num2));
		
		
	}
	
	
	public static int add(int num1,int num2) {
		return num1 + num2;
	}
	
	public static int divide(int num1,int num2) {
		if(num2==0) {
		 System.out.println("나누는 값은 0이 될 수 없습니다.");
		 return -1;
		}
		else {
			return num1/num2;
		}
	}
	
	
	
}
