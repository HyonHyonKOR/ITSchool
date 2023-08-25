package com.hyon.aug251.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//DB서버와 통신 : Java에 내장되어 있음(미완성 상태)
//DB 메이커가 많고 메이커 별로 통신이 조금씩 달라서 연결할 DB에 맞춰 설정을 맞추어야 한다.
//JDBC(Java DataBase Connectivity) - 자바에서 DB 프로그래밍을 하기 위해 사용하는 API 라이브러리
//적용하기 위해서는 해당 프로젝트의 라이브러리에 ojdbc.jar를 추가해야 한다.
public class ConnectionMain {

	public static void main(String[] args) {
	Connection con = null;
	try {	
	//연결한 DB서버 주소를 서버의 Properties->Driver Properties -> Connection URL로 설정한다	
	String addr = "jdbc:oracle:thin:@localhost:1521:xe";	
	con = DriverManager.getConnection(addr, "rnjsgurah2", "1234");
	System.out.println("Connection Succeed");
		
	}catch(Exception e) {
		e.printStackTrace();
	}
	try {
		con.close(); //반드시 닫아야 한다
	}catch(SQLException e) {
		e.printStackTrace();
	}
	
  }
}	
	