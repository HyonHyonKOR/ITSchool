package oop20230719;

public class Array13 {

	public static void main(String[] args) {
		//배열 : (int형 끼리만) 동일형의 모임
		int[][] score = { {100,100,100},
				          {60,60,60},	
				          {80,80,80},
				          {40,40,40}
		};		
		
		System.out.println("번호  국어  영어  수학  총점  평균");
		System.out.println("------------------------------");
		
		int korTotal=0, engTotal=0 ,mathTotal =0; 
		
		for(int i=0; i<score.length; i++) {
			int sum = 0;                //개인별 총점
			float avg = 0.0f;           //개인별 평균
			korTotal += score[i][0];
			engTotal += score[i][1];
			mathTotal += score[i][2];
			System.out.printf("%d", i+1);
			for(int j =0; j <score[i].length; j++) {
				sum += score[i][j];
				System.out.printf("%5d", score[i][j]);
			}
			avg = (float)sum/(float)score[i].length;  
			System.out.printf("%5d %6.1f \n", sum, avg);
		}
		System.out.println("------------------------------");
		System.out.printf("총점 %3d  %3d  %3d \n" , korTotal,engTotal,mathTotal);
		
		
		
		
		
		}//main

	}//class


