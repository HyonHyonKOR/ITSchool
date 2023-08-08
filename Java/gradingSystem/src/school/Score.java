package school;

public class Score {
//어느 학생(Student)의 어느 과목(Subject) 점수가 몇 점이다.
	private int studentId;
	private Subject subject;
	private int point;
	
	public Score(int studentId,  Subject subject, int point) {
		this.studentId = studentId;
		this.subject = subject;
		this.point = point;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	@Override
	public String toString() {
		return "학번:" + studentId + "," + subject.getSubjectName() + ":" + point + "]";
	}
	
    
}
