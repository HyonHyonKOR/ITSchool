package oop20230719;

public class Array11 {

	public static void main(String[] args) {
		//2차원 배열
		//[행][열]
		//행: 줄, row, 세로
		//열: 칸, column, 가로
		int[] a = new int[6]; //4byte x 6 = 24byte
		int[][] aa = new int[2][3]; //2x(4byte x 3 ) = 24byte
		
		a[0] = 1; a[1] = 2; a[2] = 3; a[3] = 4; a[4] = 5; a[5]=6; 
		aa[0][0] = 10;
		aa[0][1] = 20;
		aa[0][2] = 30;
		aa[1][0] = 40;
		aa[1][1] = 50;
		aa[1][2] = 60;
		
		
		for(int i =0; i<2; i++) {
			for(int j =0; j<3; j++)
			System.out.println(aa[i][j]);
		}
		
		for(int i =0; i<2; i++) {
			for(int j =0; j<3; j++) {
			System.out.print(aa[i][j] + "\t");
		    }
			System.out.println();
		}
		
		

	}

}
