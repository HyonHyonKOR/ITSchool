package oop20230810;

public class CBVCBR {
	public static void test(int a, int[] b, int[] c) {
		System.out.println("b(green) " + b);   //b(green) b의 주소
		System.out.println("c(green) " + c);   //c(green) c의 주소 
		System.out.println( a  + "a(green) "); //10a(green)
		System.out.println( b[0]  + "b(green) "); //10b(green)
		System.out.println( c[0]  + "c(green) "); //10c(green)
		System.out.println("-------------------------");
		
		a = 100;
		b[0] = 100;
		c = new int[] {100 , 200 };
		
		System.out.println("b(green) " + b);  //  b(green)b의 주소  
		System.out.println("c(green) " + c);  //  c(green)c의 다른 주소
		System.out.println( a  + "a(green) "); // 100a(green)
		System.out.println( b[0]  + "b(green) "); // 100b(green) 
		System.out.println( c[0]  + "c(green) "); // 100c(green) 
		
	}
	
	public static void main(String[] args) {
		int a = 10;
		int[] b = { 10 , 20 };
		int[] c = { 10 , 20 };
		System.out.println("b(red) " + b);     // b(red) b의 주소
		System.out.println("c(red) " + c);     // c(red) c의 주소
		System.out.println("-------------------------");
		test(a,b,c);
		System.out.println("-------------------------");
		System.out.println( a  + "a(red) ");   // 10a(red)
		System.out.println( b[0]  + "b(red) "); //100b(red)
		System.out.println( c[0]  + "c(red) "); //10c(red)
		System.out.println( "c(red) " + c); //c(red) c의 주소
	}
}
