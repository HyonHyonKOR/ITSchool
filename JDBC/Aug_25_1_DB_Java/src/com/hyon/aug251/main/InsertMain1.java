package com.hyon.aug251.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertMain1 {

	public static void main(String[] args) {
	//SQL물을 사용해서 DB 서버로 전송 후 DB 서버에서 실행해서 그 결과를 받아올 수 있어야 한다
		
	Connection con = null;
	try {	
	
	String addr = "jdbc:oracle:thin:@localhost:1521:xe";	
	con = DriverManager.getConnection(addr, "rnjsgurah2", "1234");

	//주의할 점 2가지
	String sql ="insert into product" //1. 띄어쓰기 주의!!
			+ " values(product_seq.nextval,"
			//띄어쓰기 안하면 productvalues(...) 가 되어버림
			+ "'테스트',10,10,3)"; //2. 문장 마지막에 ';' 쓰지 말 것!! 
	
	//서버에 전송/실행/결과 받아오는 작업을 하는 총괄 매니저
    PreparedStatement pstmt = con.prepareStatement(sql);
// pstmt.executeUpdate(); //서버에 전송/실행/결과받기
    
   // 서버에 전송/실행/결과받기
   // 위의 작업때문에 영향을 받은 데이터의 수가 리턴  
      int dataCount = pstmt.executeUpdate();
      if(dataCount == 1) {
    	  System.out.println("Suceess!");
      }
      
	}catch(Exception e) {
		e.printStackTrace();
	}
	try {
		con.close();
	}catch(SQLException e) {
		e.printStackTrace();
	}
	
  }

}
