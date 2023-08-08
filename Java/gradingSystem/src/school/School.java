package school;

import java.util.ArrayList;

public class School {
	
	private static final School school = new School();
	
	private static final String SCHOOL_NAME = "Good School";
	private ArrayList<Student> studentList = new ArrayList<>(); //등록된 학생
 	private ArrayList<Subject> subjectList = new ArrayList<>(); //과목 목ㄹ고
	
	private School() {};
	
	public static School getInstance() {
		return school;
	}

	
	public ArrayList<Student> getStudentList() {
		return studentList;
	}
	
	public void addStudent(Student student) {
		studentList.add(student);
	}
    
	public ArrayList<Subject> getSubjectList() {
		return subjectList;
	}

	public void addSubject(Subject subject) {
		subjectList.add(subject);
	}

	public void setStudentList(ArrayList<Student> studentList) {
		this.studentList = studentList;
	}

	public void setSubjectList(ArrayList<Subject> subjectList) {
		this.subjectList = subjectList;
	}

	public static String getSchoolName() {
		return SCHOOL_NAME;
	}
    
}//class end
