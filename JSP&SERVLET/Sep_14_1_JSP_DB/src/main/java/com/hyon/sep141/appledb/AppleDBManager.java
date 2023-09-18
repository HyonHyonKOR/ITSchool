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
	
	private Connection con = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	private int allApples = 0;
	
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
		
		String sql ="select count(*) from sep14_apple";
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


public void groupApples(int pageNum, HttpServletRequest request) {
	try{
		
    int applePerPage = 5;	
    
    int pageCount= (int)Math.ceil(allApples/(double)applePerPage);    		
	request.setAttribute("pageCount", pageCount);	
    
	con=HyonDBManager.connect("hyonPool");
	int start = (applePerPage*(pageNum-1))+1;
	int end = (pageNum ==pageCount)?allApples:(start +applePerPage-1 );
	
		String sql = "select * from "
				+ "(select ROWNUM rn,a_location,a_color,a_flavor,a_price,a_introduce "
				+ "from(select * from SEP14_APPLE order by a_price)"
				+ ") where rn >= ? and rn <=?";
		
		pstmt = con.prepareStatement(sql);
		
		pstmt.setInt(1,start);
		pstmt.setInt(2,end);
		
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

  public boolean searchApples(HttpServletRequest request) { 
	  try{
		    
			con=HyonDBManager.connect("hyonPool");
			
			String sql ="select * from sep14_apple where a_location=?";
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, request.getParameter("a_location"));
			
			rs = pstmt.executeQuery();
			
			
			while (rs.next()) {
				Apple apple = new Apple(
						 rs.getString("a_location"),
						 rs.getString("a_color"),
						 rs.getString("a_flavor"),
						 rs.getInt("a_price"),
			 			 rs.getString("a_introduce"));
				 
			request.setAttribute("apple", apple);
			return true;
			}	
			return false;	
	  }catch(Exception e){
		  e.printStackTrace();
		  return false;
		}
		finally{
			HyonDBManager.close(con,pstmt,rs);
		}  
  	}
  
  public boolean updateApple(HttpServletRequest request) {
		try{
			request.setCharacterEncoding("UTF-8");
			
			con=HyonDBManager.connect("hyonPool");
			
			String sql = "update sep14_apple set "
					+ "a_color=?, a_flavor=?, a_price=?, a_introduce=? "
	                 + "where a_location =?";
			
			pstmt = con.prepareStatement(sql);
	 		
			String introduce = request.getParameter("a_introduce").replace("\r\n", "<br>");
			
			pstmt.setString(1,request.getParameter("a_color"));
			pstmt.setString(2,request.getParameter("a_flavor"));
			pstmt.setInt(3,Integer.parseInt(request.getParameter("a_price")));
			pstmt.setString(4,introduce);
			pstmt.setString(5,request.getParameter("a_location"));
			
			if(pstmt.executeUpdate()==1) {
				request.setAttribute("r", "[수정 성공]");
				return true;
			}else {
				request.setAttribute("r", "[수정 실패]");
				return false;
			}
		}catch(Exception e){
		   e.printStackTrace();
			request.setAttribute("r", "[수정 실패]");
			return false;
		}
		finally{
			HyonDBManager.close(con,pstmt,null);
		}
	  }
  public void deleteApple(HttpServletRequest request) {
		try{
			request.setCharacterEncoding("UTF-8");
			
			con=HyonDBManager.connect("hyonPool");
			
			String sql = "delete from sep14_apple where a_location =?";
			
			pstmt = con.prepareStatement(sql);
	 					
			pstmt.setString(1,request.getParameter("a_location"));
			
			if(pstmt.executeUpdate()==1) {
				allApples--;
				request.setAttribute("r", "[삭제 성공]");
			}else {
				request.setAttribute("r", "[삭제 실패]");
			}
		}catch(Exception e){
		   e.printStackTrace();
			request.setAttribute("r", "[삭제 실패]");
		}
		finally{
			HyonDBManager.close(con,pstmt,null);
		}
	  }
  
  
}