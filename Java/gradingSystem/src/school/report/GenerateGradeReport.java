package school.report;
//각 과목당 산출 클래스
import java.util.ArrayList;
import grade.BasicEvaluation;
import grade.GradeEvaluation;
import grade.MajorEvalutaion;
import school.School;
import school.Score;
import school.Student;
import school.Subject;
import utils.Define;

public class GenerateGradeReport {
	School school = School.getInstance();
	public static final String TITLE = " 수강생 학점 \t\t\n";
	public static final String HEADER = " 이름 | 학번 | 필수과목 | 점수  \n";
	public static final String LINE = "----------------------------------\n ";
	private StringBuffer buffer = new StringBuffer();

	public GenerateGradeReport() {}
	public String getReport() {
		ArrayList<Subject> subjectList = school.getSubjectList();
		
		for(Subject subject : subjectList) {
			makeHeader(subject);
			makeBody(subject);
			makeFooter();
		}
		
		return buffer.toString(); 
	}
	
	public void makeHeader(Subject subject) {
		buffer.append(GenerateGradeReport.LINE);
		buffer.append("\t" + subject.getSubjectName());
		buffer.append(GenerateGradeReport.TITLE);
		buffer.append(GenerateGradeReport.HEADER);
		buffer.append(GenerateGradeReport.LINE);
	}
	
    public void makeBody(Subject subject) {
		ArrayList<Student> studentList = subject.getStudentList();
		
		for(int i=0; i < studentList.size(); i++) {
			Student student = studentList.get(i);
			buffer.append(student.getStudentName());
			buffer.append(" | ");
			buffer.append(student.getStudentId());
			buffer.append(" | ");
			buffer.append(student.getMajorSubject().getSubjectName());
			buffer.append(" | ");
			//학생별 수강과목 학점 계산
			getScoreGrade(student, subject.getSubjectId());
			buffer.append("\n");
			buffer.append(LINE);
		}//for end
	}//makeBody() end
    
    public void getScoreGrade(Student student, int subjectId ) {
    	ArrayList<Score> scoreList = student.getScorelist();
    	int majorId = student.getMajorSubject().getSubjectId();
    	// 학점 평가 클래스 
    	GradeEvaluation[] gradeEvaluation = {new BasicEvaluation(), new MajorEvalutaion()};
    	
    	for(int i=0; i<scoreList.size(); i++) {
    		Score score = scoreList.get(i);
    		if(score.getSubject().getSubjectId() == subjectId) {
    			String grade;
    			if(score.getSubject().getSubjectId() == majorId) {
    				grade = gradeEvaluation[Define.SAB_TYPE].getGrade(score.getPoint());
    	       }else
    	    	  grade = gradeEvaluation[Define.AB_TYPE].getGrade(score.getPoint());
    			
    			buffer.append(score.getPoint());
    			buffer.append(" : ");
    			buffer.append(grade);
    			buffer.append(" | ");
    		}	
		}
	}//getSocreGrade() end
    
    public void makeFooter() {
    	buffer.append("\n");
    }
}//class end
