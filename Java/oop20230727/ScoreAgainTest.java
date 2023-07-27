package oop20230727;
import java.util.*;
public class ScoreAgainTest {

	public static void main(String[] args) {
		
		int[] subject = new int[3];
		System.out.println("국어, 영어, 수학 점수를 입력하세요!");
		Scanner sc = new Scanner(System.in);
		
		for(int i=0; i<subject.length;i++) {
			subject[i] = sc.nextInt();
		}
		sc.close();
		
		ScoreAgain obj = new ScoreAgain(subject);
		System.out.println("총점 : " + obj.calSum());
		System.out.println("평균 : " + obj.calAverage());
		
		obj.setSubject(subject);
		System.out.println("\n====배열 getter/setter====");
		int[] arr = obj.getSubject();
		for(int i: arr) {
			System.out.print(i + "\t");
		}
		
	}

}
