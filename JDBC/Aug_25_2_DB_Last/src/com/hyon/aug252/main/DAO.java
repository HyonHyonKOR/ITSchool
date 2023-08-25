package com.hyon.aug252.main;
import java.sql.Connection;
import com.hyon.db.manager.HyonDBManager;

//DAO / DTO 패턴
// MVC 패턴의 M
// DAO (Data Access Object)
//          : M 중에서 DB관련한 작업을 전담하는 클래스
// DTO (Data Transfer/ Temp Object)
//         : DAO의 작업결과를 표현하는 클래스

// java.util.Date - 주력(Spring에서는 이걸 원함)
// java.sql.Date - JDBC에서는 이걸 원함

// java.util.Date -> java.sql.Date
//    : new Date(클래스명.get날짜관련멤버변수명().getTime());

//java.sql.Date -> java.util.Date : 알아서 바꿔줌

public class DAO {
	
	 
   	
	
	
 	  
}


//1. 예약하기 (직접 입력, 날짜는 연-월-일/시:분)     예약자 이름, 예약자 시간, 예약자 전화번호, 예약 지점 -> 예약번호 리턴 
//2. 매장 등록 (지점명, 지점장,좌석수)                 지정명, 지점장, 좌석수 -> 지점 번호는 알아서
//3. 전체 예약 확인 (날짜는 연-월-일 요일 오전/오후 시:분)  
//4. 전체 매장 조회 (위치(좌석 수 - 사장님 이름)     
//5. 매장 찾기 (최소 좌석 수 입력 => 좌석 수 이상의 매장 정보 출력)
//6. 예약 찾기 (예약자의 이름으로)                      
//7. 예약 정보 수정 (예약번호를 입력하면, 연락처를 변경)
//8. 예약 취소(예약번호로 취소)
//9. 종료