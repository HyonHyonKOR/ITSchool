package com.hyon.aug251.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DeleteMain {
	public static void main(String[] args) {
		//상품명 입력(Scanner) => 입력한 내용을 포함하는 상품명의 정보를 삭제
		Connection con = null;
		PreparedStatement pstmt = null;
		Scanner sc = new Scanner(System.in);
		try {
			//연결
			String addr = "jdbc:oracle:thin:@localhost:1521:xe";
			con = DriverManager.getConnection(addr,"rnjsgurah2","1234");
			
			//입력
			System.out.print("상품명 입력 : ");
			String name = sc.next();
			sc.close();
			
			//문제점 :  여기는 자바의 영역... % 주의! 
			// %를 문자로 만들어서 문자들을 연결시켜주는 파이프를 사용
			String sql = "delete from product "
					+ "where p_name like '%'||?||'%'";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,name );
			
			//삭제
			if(pstmt.executeUpdate()>=1) {
				System.out.println("success");
			}	
		}catch(Exception e) {
			e.printStackTrace();
		}finally{
			try {
			pstmt.close();
			}catch(SQLException e){
				e.printStackTrace();
			}try {
				con.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
