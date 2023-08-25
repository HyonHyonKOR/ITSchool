package com.hyon.aug251.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class UpdateMain {
	//매장명입력 => 그 단어를 포함하는 모든 매장의 상품을 20% 할인된 가격으로 바꾸기
	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement pstmt = null;
	
	try {
		//연결
		String addr = "jdbc:oracle:thin:@localhost:1521:xe";
		con = DriverManager.getConnection(addr,"rnjsgurah2","1234");
		System.out.println("success");
		
		//입력
		Scanner k = new Scanner(System.in);
		System.out.print("매장명: ");
		String name = k.next();
		k.close();
		
		String sql ="update product set p_price=p_price*0.8 where p_m_no in"
				+ "(select m_no from market where m_name like '%'||?||'%')";
		
		
		//처리
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1,name);	    
		if(pstmt.executeUpdate()>=1) {
			System.out.println("success");
		}		
	}catch(Exception e ) {
		e.printStackTrace();
	}finally {
		try {
			pstmt.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}try {
			con.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

	}//main()end
}//Class end
