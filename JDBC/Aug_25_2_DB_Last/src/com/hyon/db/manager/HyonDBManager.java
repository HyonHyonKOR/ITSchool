package com.hyon.db.manager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class HyonDBManager {
	public static Connection connect() throws SQLException{
		String addr = "jdbc:oracle:thin:@localhost:1521:xe";	
		return DriverManager.getConnection(addr, "rnjsgurah2", "1234");
	}
	
	public static void close(Connection con, PreparedStatement pstmt, ResultSet rs) {
		try {
			rs.close();                   //C,U,D때는 필요없고 , R 때만 필요
		}catch(Exception e) {      // Insert하게 되면 NullPointerException이 발생
			                                  // 모든 Exception이 잡히도록 할 것!
		}try {                            //메시지는 안보려고!
			pstmt.close();
		}catch(Exception e) {
			
		}try {
			con.close();
		}catch(Exception e) {
		}
	}
	
	
	
}
