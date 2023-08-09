package oop20230809;

import java.util.Scanner;

public class EMain1 {
	
	public static void start() {
		System.out.println("===========================");
		System.out.println("\t\t1.학생수 | 5. 종료");
		System.out.println("===========================");
	}
	
	public static void showMenu() {
		System.out.println("==================================================");
		System.out.println("1.학생수 | 2. 점수 입력 | 3. 점수 리스트 | 4. 분석 | 5. 종료" );
		System.out.println("==================================================");
	}
	 
	public static int getSelectNo() {
		Scanner k = new Scanner(System.in);
		System.out.println("선택 >");
		int selectNo = k.nextInt();
		return selectNo;
	}
	
	public static int getStudentNum() {
		Scanner k = new Scanner(System.in);
		System.out.println("학생 수 :");
		int studentNum = k.nextInt();
		return studentNum;
	}
	
	
	//학생 개인 점수를 받아오기
	public static int getScore() {
		Scanner k = new Scanner(System.in);
		int score = k.nextInt();
		if(score > 100 ) {
			System.out.println("점수는 100점을 넘을 수 없습니다.");
			System.out.println("다시 입력 : ");
		}else if(score < 0) {
			System.out.println("점수는 0점보다 낮을 수 없습니다.");
			System.out.println("다시 입력 : ");
		}
		return (score >= 0 && score <= 100)? score : getScore(); //재귀 호출 
	}
	
	//학생들의 점수를 입력하기
	public static int[] getScore(int[] scores) {
		for(int i=0; i<scores.length; i++) {
			System.out.printf("%d번 학생 점수 입력 : ", i + 1);
			scores[i] = getScore();
		}
		return scores;
	}
	
	//학생들의 점수를 출력하기
	public static void printScore(int[] scores) {
		int index = 1;
		for (int i : scores) {
			System.out.printf("%d번 학생 점수 : %d점\n" , index++, i);                   
		}
	}
	
	//최고 점수, 평균 점수 출력하기
	public static void printStats(int[] scores) {
		int max = 0;
		int sum = 0;
		for (int i : scores) {
			sum += i; //총점
			max = (max < i) ? i:max;
		}
		double avg = (double)sum/scores.length;
		System.out.printf("최고 점수 : %d점\n", max);
		System.out.printf("평균 점수 : %.2f점\n", avg);
	}
	
	//종료 메세지
	public static void end() {
		System.out.println("\t\t\t종료합니다.");
		System.out.println("===============================================");
	}
	
	
	
	// 전체적인 프로그램이 돌아갈 기능
	
	public static void activate() {
		int selectNo = 0;
		int studentNum = 0;
		int[] scores = null;
		
		start();
		selectNo = getSelectNo();
		if(selectNo == 1) {
			studentNum = getStudentNum();
			scores = new int[studentNum];
			while(true) {
				showMenu();
				selectNo = getSelectNo();
				if(selectNo == 1) {
					studentNum = getStudentNum();
					scores = new int[studentNum];
				}else if(selectNo == 2){
					getScore(scores);
				}else if(selectNo == 3) {
					printScore(scores);
				}else if(selectNo == 4) {
					printStats(scores);
				}else if (selectNo == 5) {
					end();
					break;
				}else {
					System.out.println("\t입력이 잘못되었습니다.");
					System.out.println("\t다시 입력하세요.");
				}
			}
		}else if (selectNo == 5) {
			end();
		}else {
			System.out.println("\t입력이 잘못되었습니다.");
			System.out.println("\t다시 입력하세요.");
		}
	}
	 
	public static void main(String[] args) 	{
		activate();
	}//main end



}//class end

