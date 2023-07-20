package oop20230720;

public class Method3 {
	public static int fun3(int n) {
		return 1000+ n;
	}
	public static int fun2(int n) {
		return fun3(200+n);
	}
	public static int fun1(int n) {
		return fun2(1);
	}
	public static void main(String[] args) {
	   System.out.println(fun1(1));
	}//main() end
}//class
