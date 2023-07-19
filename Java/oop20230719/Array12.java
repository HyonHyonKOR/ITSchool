package oop20230719;

public class Array12 {

	public static void main(String[] args) {
		//2차원 배열의 선언 및 초기화(Initialize)
		int [][] num = {{10,20,30},{40,50,60},{70,80,90}};
		int row = num.length;
		int col = num[0].length;
		System.out.println(row + "행 " + col + "열");
		
		//전체 요소의 합계
		int sum=0;
		for(int r=0; r<row; r++) {
			for(int c=0; c<col; c++) {
				sum += num[r][c];
			}
		}
		System.out.println("전체 요소의 합계: " + sum);
		
		//각 행의 출력
		int rowSum = 0;
		for(int r=0; r<row; r++) {
			rowSum = 0;
			for(int c=0; c<col; c++) {
				rowSum += num[r][c];
			}
			System.out.println(r+"행의 합계: " + rowSum);
		}
		System.out.println("전체 요소의 합계: " + sum);
		//2. 각각의 대각선()의 합계 출력
		int sum1= 0;//
		int sum2= 0;//
		for(int r=0; r<=2; r++) {
			sum1 += num[r][r];                
			sum2 += num[r][2-r];                
			
		}
		System.out.println("대각선 ↘의 합계: " + sum1);
		System.out.println("대각선 ↙의 합계: " + sum2);
		
	
		
	}
}
