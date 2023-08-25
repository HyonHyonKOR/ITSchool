package com.hyon.aug251.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SelectMain {
	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String addr = "jdbc:oracle:thin:@localhost:1521:xe";    	 
	    	 con = DriverManager.getConnection(addr,"rnjsgurah2","1234");
			
			//상품 이름을 오름차순으로 정렬
	    	 String sql ="select * from product order by p_name";
	    	 pstmt = con.prepareStatement(sql);
	    	 
	    	 //Read 시에는 setUpdate가 아닌 setQuery를 사용한다
	    	 //pstmt.executeUpdate() : 몇 개나 영향을 받았는가 (C,U,D)
	    	 //pstmt.executeQuery() : 데이터(R)
	    	 
	    	 //select문을 수행한 결과 : ResultSet
	    	 //        List와 비슷한 느낌
	    	 
	    	 rs = pstmt.executeQuery();
	    	
	    	 while (rs.next()) {
				// rs.getXXX("컬럼명") :현재 위치의 컬럼 읽기
	    		// rs.getXXX(인덱스) : 비추
	    		System.out.println(rs.getString(2));
	    		System.out.println(rs.getInt("p_weight"));
	    		System.out.println(rs.getInt("p_price"));
	    		System.out.println("---------------");
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
