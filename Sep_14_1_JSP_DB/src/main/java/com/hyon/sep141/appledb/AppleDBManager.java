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
	int allApples = 0;
	
public void showTable(HttpServletRequest request) {
	try{
		con=HyonDBManager.connect("hyonPool");
		
		String sql = "select * from sep14_apple order by a_price";
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


public void insertTable(HttpServletRequest request) {
	try{
		request.setCharacterEncoding("UTF-8");
		
		con=HyonDBManager.connect("hyonPool");
		
		String sql = "insert into sep14_apple values(?,?,?,?,?)";
		pstmt = con.prepareStatement(sql);
		
		
//		String location = request.getParameter("a_location");
//		String color = request.getParameter("a_color");
//		String flavor= request.getParameter("a_flavor");
//		int price = Integer.parseInt(request.getParameter("a_price"));
 		String introduce = request.getParameter("a_introduce").replace("\r\n", "<br>");
		
		pstmt.setString(1,request.getParameter("a_location"));
		pstmt.setString(2,request.getParameter("a_color"));
		pstmt.setString(3,request.getParameter("a_flavor"));
		pstmt.setInt(4,Integer.parseInt(request.getParameter("a_price")));
		pstmt.setString(5,introduce);
		
		
		if(pstmt.executeUpdate()==1) {
			allApples++;
		}
	}catch(Exception e){
	   e.printStackTrace();
	   
	}
	finally{
		HyonDBManager.close(con,pstmt,null);
	}
  }

public void countAllApples() {
	try{
		con=HyonDBManager.connect("hyonPool");
		
		String sql = select row
		
		
		
		pstmt = con.prepareStatement(sql);
		rs = pstmt.executeQuery();
		
		rs.next();
		allApples= rs.getInt("count(*)");
		
		
			
	}catch(Exception e){
	   e.printStackTrace();
	   
	}
	finally{
		HyonDBManager.close(con,pstmt,rs);
	}
  }

public void groupApples(int PageNum, HttpServletRequest request) {
	try{
	con=HyonDBManager.connect("hyonPool");
		
		String sql = "select * from sep14_apple order by a_price";
		
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