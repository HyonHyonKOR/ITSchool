package oop20230809;

import java.util.*;

public class ScoreSystem {
       
	private static Scanner sc = new Scanner(System.in);
	private static final ScoreSystem studentlist = new ScoreSystem();
    private int studentNum = 0;
	
	private ScoreSystem() {}; 

	private static Student[] studentsInfo = null;

	public static ScoreSystem getInstance() {
	   return studentlist;	
	}
	
	public void makeStudentList() {
		System.out.print("학생 수 입력 >>>");
		int studentInfoNum = sc.nextInt();
		System.out.println();
		 
		if(studentInfoNum<=0) {
			System.out.println("학생 수를 다시 입력해주세요.");
			System.out.println();
			return;
		    }	
		
		studentsInfo = new Student[studentInfoNum];
		System.out.println( studentInfoNum + "명의 점수리스트를 작성했습니다. ");
		System.out.println();
	}
	
	
	public void inputStudentScore() {
	    if(studentsInfo == null) {
			System.out.println("학생 수를 먼저 입력해주세요.");
			System.out.println();
			return;
		}
		System.out.print("학생 점수 입력 >>>");
		int studentScore = sc.nextInt();
		System.out.println();
		
		if(studentScore<0 || studentScore>100) {
			System.out.println("0~100까지의 점수를 다시 입력해주세요.");
			System.out.println();
			return;
		}
		studentNum++;
		studentsInfo[studentNum-1] = new Student(studentNum,studentScore);
		System.out.println(studentNum +"번 학생의 점수를 입력했습니다.");
		System.out.println();
	}
	
	public void printStudentScoreList() {
	    if(studentsInfo == null) {
			System.out.println("학생 수를 먼저 입력해주세요.");
			System.out.println();
			return;
		}
	    
	    for(Student i : studentsInfo) {
	    	if(i==null) {
	    	  System.out.println("아직 "  + (studentsInfo.length-studentNum)+ "명의 점수가 입력되지 않았습니다.");	
	    	  System.out.println();
	    	  return;
	        }
	    	System.out.println(i.toString());
	    }
	    System.out.println();
	}
	
	public void getBestAndAvg() {
		 if(studentsInfo == null) {
			System.out.println("학생 수를 먼저 입력해주세요.");
			System.out.println();
			return;
		 }
		 
		 int bestScore = studentsInfo[0].getScore();	
		 double avgScore = 0;
	
		 
		 for(int i=0; i<studentsInfo.length; i++) {
			 if(studentsInfo[i]==null) {
		    	  System.out.println("아직 "  + (studentsInfo.length-studentNum)+ "명의 점수가 입력되지 않았습니다.");	
		    	  System.out.println();
		    	  return;
			 }  
		    else if(studentsInfo[i].getScore()>bestScore) {
				  bestScore = studentsInfo[i].getScore();
			  }
			  avgScore += studentsInfo[i].getScore();
	        }
		 
		 
		 System.out.println("최고 점수 : " + bestScore + "점"); 
		 System.out.printf("평균 점수 : %.2f점\n" , (double)avgScore/(double)studentNum); 
		 System.out.println();
	}
	
	public void finishProgram() {
		System.out.println("프로그램을 종료합니다.");
		System.exit(0);
	}
	
}	
	
	
	
	

