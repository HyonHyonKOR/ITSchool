package school;

import java.util.ArrayList;
import utils.Define;

public class Subject {
	private String subjectName;
	private int subjectId;
	private int gradeType;    //학점 평가 정책 (일반과목 0, 필수과목 1)
	
	private ArrayList<Student> studentList = new ArrayList<Student>();

	public Subject(String subjectName, int subjectId) {
		this.subjectName = subjectName;
		this.subjectId = subjectId;
		this.gradeType = Define.AB_TYPE;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public int getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}

	public int getGradeType() {
		return gradeType;
	}

	public void setGradeType(int gradeType) {
		this.gradeType = gradeType;
	}

	public ArrayList<Student> getStudentList() {
		return studentList;
	}

	public void setStudentList(ArrayList<Student> studentList) {
		this.studentList = studentList;
	}
	
	//수강 신청 메서드
	public void register(Student student) {
		studentList.add(student);
	}
}
