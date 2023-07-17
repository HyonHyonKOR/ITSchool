package oop20230713;

public class LoopEx3 {
	public static void main(String[] args) {
		
		for(int i=0; i<5; i++) {
			for(int j=0; j<2*(i+1)-1;j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
	}
}


/*
0행 *   
1행 ***      //2의 배수 - 1 
2행 ***** 
3행 ******* 
4행 *********
*/