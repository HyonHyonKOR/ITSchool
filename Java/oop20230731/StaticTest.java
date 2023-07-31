package oop20230731;

class Pay{
	public static String COMPANY = "SOLDESK";    //static field
	public static double TAX = 0.03;             //static field
	public static int SUDANG = 200;              //static field
	public int num = 123;                        //instance field(new)
	
	public void line() {
		System.out.println("--------------------");
	}
	public static void disp() {
		System.out.println("====================");
	}
}

public class StaticTest {

	public static void main(String[] args) {
		System.out.println(Pay.COMPANY);
		System.out.println(Pay.TAX);
		System.out.println(Pay.SUDANG);
		Pay.disp();
		
		Pay p1 = new Pay();
		p1.line();


	}

}
