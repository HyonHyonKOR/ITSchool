package oop20230809;

public class Student {
	
	private int studentId;
	private int score;
	
	public Student() {}
	
	public Student(int studentId, int score) {
		this.studentId = studentId;
		this.score = score;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return studentId + "번 학생 점수 : " + score + "점";
	}
	
        	

}
