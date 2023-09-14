package com.hyon.sep141.appledb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import com.hyon.db.manager.HyonDBManager;

public class AppleDBManager {
	
	private final static AppleDBManager adm = new AppleDBManager();
	
	private AppleDBManager() {}
	
	public static AppleDBManager getInstance() {
		return adm;
	}
	
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
public void showTable(HttpServletRequest request) {
	try{
		con=HyonDBManager.connect("hyonPool");
		
		String sql = "select * from sep14_apple";
		pstmt = con.prepareStatement(sql);
		rs = pstmt.executeQuery();
		
		ArrayList<Apple> apples = new ArrayList<>();
		
		while (rs.next()) {
		apples.add(new Apple(
				 rs.getString("a_location"),
				 rs.getString("a_color"),
				 rs.getString("a_flavor"),
				 rs.getInt("a_price"),
				 rs.getString("a_introduce")));
		}	
		
		request.setAttribute("apples", apples);

	}catch(Exception e){
	   e.printStackTrace();
	   
	}
	finally{
		HyonDBManager.close(con,pstmt,rs);
	}
  }


  
}