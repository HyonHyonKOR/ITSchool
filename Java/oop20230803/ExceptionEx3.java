package oop20230803;

public class ExceptionEx3 {

	public static void main(String[] args) {
	try {	
		int[] num = new int[3];
		for(int i = 0; i<=3; i++) {
			num[i] = i*2;
			System.out.println("-----");
		}
	   }catch(ArrayIndexOutOfBoundsException e) {
		   System.out.println(e.toString());
	   }finally {
		   System.out.println("END");
	   }
		
	}

}
