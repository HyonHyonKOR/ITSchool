package com.hyon.oct062.student;

import java.util.List;

public interface StudentMapper {
	//method 리턴타입
    // 	insert/ update/ delete => 영향을 받은 데이터의 수 - int
	//  select 
	// 		결과가 하나 나온다 : resultType객체 (Student)
	//      격과가 여러개 나온다 : List<resultType객체) (List<Student>)
	
	// 메소드명: mapper.xml의 id의 맞추기!!
	// 파타미터: mapper.xml의 parameterType과 맞추기!!
	public abstract int regStudent(Student s);
	
	
	//resultType은 작성한 타입에 맞는 클래스에 매핑이 자동으로 이루어짐
	//+ 따로 설정하지 않아도 select의 결과가 여러개면 List형식으로 반환
	public abstract List<Student> readAllStudents(); 
}
