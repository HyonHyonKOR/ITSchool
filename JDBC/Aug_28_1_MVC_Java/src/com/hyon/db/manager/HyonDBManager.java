package com.hyon.db.manager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class HyonDBManager {

	public static Connection getConnection() throws SQLException {
		  String address = "jdbc:oracle:thin:@localhost:1521:xe";
		  return DriverManager.getConnection(address, "rnjsgurah2", "1234");
	}
	
	public static void close(Connection con, PreparedStatement pstmt, ResultSet rs) {
		  try {
			  rs.close();
		  }catch(Exception e){
		  }try {
			  pstmt.close();
		  }catch(Exception e) {  
		  }try {
			  con.close();
		  }catch(Exception e) {
		  }
	}
}
