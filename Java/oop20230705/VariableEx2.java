package oop20230705;

public class VariableEx2 {
	
	public static void main(String[] args) {
		boolean b = false;
		System.out.println(b);
		System.out.print(b + "\n");
		System.out.printf("%b\n" ,b);

		char grade = 'A';
		System.out.println(grade);
		System.out.printf("%c\n", grade);
		
		String name = "홍길동";
		System.out.println(name);
		System.out.printf("%s\n", name);
		
		int year = 2023;
	    System.out.println(year);
	    System.out.printf("%d\n", year);
	    
	    float f1 = 3.14f;
	    System.out.println(f1);
	    System.out.printf("%f\n", f1);
	    
	    double f2 = 3.14;
		System.out.println(f2);
		System.out.printf("%f\n", f2);
	}
}

/*자료형(data type)
 * 1. 기본(primitive) 자료형
 *  1)정수형: byte(1)->char(2)->short(2)->int(4)->long(8)
 *  2)실수형: float(4)->double(8)
 *  3)문자형: character(2)   
 *  4)논리형: boolean(1)
 * 2. 참조(reference) 자료형(확장형, 사용자정의형)
 *  1)Class(클래스)
 *  2)interface(인터페이스형)
 *  3)array(배열형)
 *  4)enumeration(열거형)
 */
