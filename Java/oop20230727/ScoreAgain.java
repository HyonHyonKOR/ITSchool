package oop20230727;

public class ScoreAgain {
	//필드 : 배열이 있는 경우
	private int[] subject;
	//생성자
	public ScoreAgain() {}
	public ScoreAgain(int[] subject) {
		this.subject = subject;
	}
	//메서드
	public int[] getSubject() {
		return subject;
	}
	public void setSubject(int[] subject) {
		this.subject = subject;
	}
	//총점, 평균을 구하는 메서드
	public int calSum() {
		int sum =0;
		for(int i : subject) {
			sum += i;}
		return sum;
	}
	
	public double calAverage() {
		return (double)calSum()/subject.length;//갯수
	}
	
}//class end
