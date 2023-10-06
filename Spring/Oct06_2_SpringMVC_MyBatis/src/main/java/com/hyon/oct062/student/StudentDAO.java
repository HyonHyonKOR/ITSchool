package com.hyon.oct062.student;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentDAO {
	
  
	@Autowired
	private SqlSession ss;
	
	public void regStudent(Student s, HttpServletRequest req) {
		try {
			
			// 연결 - 자동(SqlsessionTemplate 때문에) - connect, close 필요 X
			
			// 값을 받아오기 & 객체로 만들기 - Spring이 해결
			
			//내용 출력
//			System.out.println(s.getS_name());
//			System.out.println(s.getS_nickname());
			
			// SQL 수행 - MyBatis 활용
			//  interface를 가져온다!!
			
			StudentMapper sm = ss.getMapper(StudentMapper.class);
			
			// interface에 있는 abstract method(추상 메소드) 호출
			// =자동=> 연결이 되어있는 mapper.xml의 해당부분이 실행	
			if(sm.regStudent(s) == 1) {
				req.setAttribute("r", "학생 등록 성공!");
				//ss.commit(); => commit 자동!
			}
		}catch(Exception e) {
			e.printStackTrace();
			req.setAttribute("r", "학생 등록 실패!");
		}	

	}
	
	public void readAllStudents(HttpServletRequest req) {
		try {
			List<Student> sList = ss.getMapper(StudentMapper.class).readAllStudents();
			req.setAttribute("sList", sList);	
			
		}catch(Exception e) {
			e.printStackTrace();
			req.setAttribute("r", "학생 검색 실패!");
		}
	}
	
}
