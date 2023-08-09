package oop20230809;

import java.util.InputMismatchException;
import java.util.Scanner;

public class EMain {
   
	 public static void main(String[] args) {
		activate();
	 }//main() end
	
	 public static void activate() {
			
	 Scanner sc = new Scanner(System.in);
	  
		while(true) {
		 try{ 
			System.out.println("#################################################");
			System.out.print("#1.학생 수 입력 | 2. 학생 점수 입력 | 3. 학생 점수 출력	#\n");
			System.out.print("# 4.최고 점수 및 평균 점수 출력  |   5. 프로그램을 종료 	#\n");
			System.out.println("#################################################");
			System.out.println();
			System.out.print("메뉴 번호 입력 >>>");
			
			ScoreSystem scoresystem = ScoreSystem.getInstance();
			int menuNumber = sc.nextInt();  
			System.out.println();

			switch(menuNumber) {
			case 1:{scoresystem.makeStudentList();   	break;}
			case 2:{scoresystem.inputStudentScore();	break;}	
			case 3:{scoresystem.printStudentScoreList();break;}
			case 4:{scoresystem.getBestAndAvg();		break;}
			case 5:{scoresystem.finishProgram();			  }		
	        } 
	     }
		 catch (InputMismatchException e) {
		    System.out.println("숫자를 입력해주세요.");
		    sc.nextLine();
		    System.out.println();
		    continue;
		 }
	   }
	  	   
	}//activate() end 
	
	 
}//class end





