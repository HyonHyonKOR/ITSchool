package oop20230720;

public class ArrayEx13Rotate {

	public static void main(String[] args) {
		int [][] score = {
				{80,80,80},	               
				{90,90,90},	
				{75,75,75},
				{95,95,95},
				{60,60,60}     //00->42 01-> 41 02->40
		}; 
		
		int[] stdTotal = new int[5]; // (학생)개인별 총점
		float[] stdAvg = new float[5]; // (학생)개인별 평균
		int[] subTotal = new int[3]; // (3)과목별 총점
		float[] subAvg = new float[3]; // (3)과목별 평균
		
		int row = score.length;  //5
		int column = score[0].length;  //3	
		
		
		for(int i=0; i<score.length; i++) {
			for(int j=0; j<score[i].length; j++) {
				stdTotal[i]  += score[i][j];
			}
		  stdAvg[i] = (float)stdTotal[i]/(float)score[i].length;
		}
		
		
			                                                      
		int[][] rotate = new int[column][row]; 
		
		
		//90 
		for(int i=0; i<rotate.length; i++)  {                   
			for(int j=0;j<rotate[i].length; j++){                  
				rotate[i][j]= score[row-1-j][i];                             
			}
	    }	
		
		//180
		
		int[][] rotate2 = new int[row][column];
		
		for(int i=0; i<rotate2.length; i++)  {                   
			for(int j=0;j<rotate2[i].length; j++){                  
				rotate2[i][j]= score[row-1-i][column-j];                             
			}
	    }	
		
		//270
		
		int[][] rotate3 = new int[column][row]; 
		
		for(int i=0; i<rotate3.length; i++)  {                   
			for(int j=0;j<rotate3[i].length; j++){                  
				rotate[i][j]= score[row-1-j][i];                             
			}
	    }	
		
		
		
		for(int i=0; i<rotate.length; i++) {
			for(int j=0; j<rotate[i].length; j++) {
				subTotal[i]  += rotate[i][j];
			}
		  subAvg[i] = (float)subTotal[i]/(float)rotate[i].length;
		}
		
		
		
		
		
		
		  System.out.printf("학생 개인별 종점 : ");
		  for(int a: stdTotal) {
			  System.out.print(a+" ");
		  }
		  
		  System.out.println();
		  
		  System.out.printf("학생 개인별 평균 : ");
		  for(float a: stdAvg) {
			  System.out.print(a+" ");
		  }
		  
		  System.out.println();
		
		  System.out.printf("과목별 종점     : ");
		  for(int a: subTotal) {
			  System.out.print(a+" ");
		  }  
		  
          System.out.println();
		  
		  System.out.printf("과목별 평균     : ");
		  for(float a: subAvg) {
			  System.out.print(a+" ");
		  }
		
	}

}