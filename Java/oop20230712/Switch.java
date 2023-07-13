
package oop20230712;

public class Switch {
	public static void main(String[] args) {
		
		int kor = 90;
		int eng = 90;
		int math =90;
		int total =kor + eng + math;
		double avg = (double)total/3;
		char grade = ' ';
		
		int average = (int)avg/10;
				
		switch(average) {
		case 10:
		case 9:
			grade = 'A'; break;
		case 8:
			grade = 'B'; break;
		case 7:
			grade = 'C'; break;
		default :
		    grade = 'F';
		}
		System.out.println(grade); 
	}
}
