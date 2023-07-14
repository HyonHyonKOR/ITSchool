package oop20230712;

import java.util.Scanner;

public class SelectionEx8 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("국어 점수를 입력해주세요: ");
		int korScore = sc.nextInt();
		System.out.print("영어 점수를 입력해주세요: ");
		int engScore = sc.nextInt();
		System.out.print("수학 점수를 입력해주세요: ");
		int mathScore = sc.nextInt();
		
			if(korScore<50||engScore<50||mathScore<50) {
				System.out.println("과락입니다.");
			}
			else if(korScore + engScore + mathScore >= 210) {
				System.out.println("합격입니다.");
			}
			else {
				System.out.println("불합격입니다.");
			}
			
		sc.close();

	}

}

//클래스명(파일명) : SelectionEx8.java

//국어, 영어, 수학 점수를 입력 받아서, 평균을 구한 후, 
//"합격", "불합격" 출력하기

//평균이 70 이상이고, 모든 과목이 50 이상이어야 합격

//불합격의 경우는 과락과 불합격으로 구분

//과락 : 평균이 70 이상이더라도, 한 과목이라도 50미만이면 과락
//불합격 : 나머지는 불합격