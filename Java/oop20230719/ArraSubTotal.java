package oop20230719;
import java.util.Scanner;

public class ArraSubTotal {

	public static void main(String[] args) {
		
	int totalSum =0;	
	Scanner sc =new Scanner(System.in);
	int[][] b = new int[4][2]; 
	
	for(int i=0; i<b.length; i++ ) {
		for(int j=0; j<2;j++) {
			System.out.printf("%d층 %d호 입력 : " , i+1,j+1);
			b[i][j] = sc.nextInt();
		}
	}

	System.out.println();
	System.out.println("----------------");
	
	for(int i=0; i<b.length; i++ ) {
		int floorSum = 0;
		for(int j=0; j<2;j++) {
			floorSum += b[i][j];
		}
		System.out.printf("%d층 인구수 : %d명\n" , i+1, floorSum);
		totalSum += floorSum;
	}
	System.out.println("----------------");
	System.out.println();
	System.out.printf("전체 인구수 : %d명\n" ,totalSum);
	
	
	sc.close();
	}

}

