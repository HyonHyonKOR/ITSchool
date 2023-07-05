package oop20230705;

public class VariableEx3 {

	public static void main(String[] args) {
		int total=0;
		int[] scores = {100,25,84};
		for(int score:scores) {
			total += score;
		}
		double avg1 = (double)total/scores.length;
		
		System.out.println("3과목의 총점 : " + total + "점"  );
		System.out.print("3과목의 평균 : ");
		System.out.printf("%.1f점",avg1);
	}
}