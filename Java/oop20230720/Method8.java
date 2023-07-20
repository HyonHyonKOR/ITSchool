package oop20230720;

public class Method8 {
	public static int add(int n, int m) {
		return m+n;
	}
	
	public static double add(double n, double m) {
		return m+n;
	}
	
	public static char add(char m, char n) {
		return (char)(m+n);
	}
	
	public static String add(String m, String n) {
		return m+n;
	}

	public static void main(String[] args) {
		
		int    r1 =  add(10,20);
		double r2 =  add(1.1,2.2);
		char   r3 =  add('1', 'A');
		String r4 =  add("Method","Overloading");
		
		System.out.println(r1);
		System.out.println(r2);
		System.out.println(r3);
		System.out.println(r4);
		

	}

}
