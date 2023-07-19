package oop20230719;

public class Array13Ex {

	public static void main(String[] args) {
		
		int [][] score = {
				{80,80,80},	    //00 10 20 30 40 50 
				{90,90,90},	
				{75,75,75},
				{95,95,95},
				{60,60,60}
		}; 
		
		int[] stdTotal = new int[5]; // (학생)개인별 총점
		float[] stdAvg = new float[5]; // (학생)개인별 평균
		int[] subTotal = new int[3]; // (3)과목별 총점
		float[] subAvg = new float[3]; // (3)과목별 평균
		
		
		for(int i=0; i<score.length; i++) {
			for(int j=0; j<score[i].length; j++) {
				stdTotal[i]  += score[i][j];
			}
			stdAvg[i] = (float)stdTotal[i]/(float)score[i].length;
			
				subTotal[0]+= score[i][0];
				subTotal[1]+= score[i][1];
				subTotal[2]+= score[i][2];
			    
			
			    if(i==4) {
				       for(int y=0; y<subAvg.length; y++) {
					subAvg[y] = (float)subTotal[y]/(float)score.length;
				    }
				
			   }
			
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

