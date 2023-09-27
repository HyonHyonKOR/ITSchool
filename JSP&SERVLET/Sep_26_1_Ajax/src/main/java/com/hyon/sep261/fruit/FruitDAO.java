package com.hyon.sep261.fruit;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.hyon.db.manager.MemberDBManager;

public class FruitDAO {

	public static void getAllfruits(HttpServletRequest req) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		  
		try {
			  
		  con = MemberDBManager.connect("hyonPool");  
		  String sql = "select * from sep26_fruit order by f_price";
		  
		  pstmt = con.prepareStatement(sql);
		  rs = pstmt.executeQuery();
		  
		  ArrayList<Fruit> fruits = new ArrayList<>();
		  Fruit fruit = null;
		  while(rs.next()) {
			  fruit = new Fruit();
			  fruit.setF_name(rs.getString("f_name"));
			  fruit.setF_price(rs.getInt("f_price"));
			  fruits.add(fruit);
		  }
		  //작업
		  //결과처리
		  //request.attribute - 이번 요청에서만 결과 사용 가능
		  //session.attribute - (서버-클라이언트의 연결상태)가 살아있다면 결과 사용 가능
		  //cookie - 제한 시간 내에서는 무조건 결과 사용 가능    
		  req.setAttribute("fruits", fruits);
		  
	      }catch(Exception e){
		  e.printStackTrace();
		  
	}finally {
		MemberDBManager.close(con, pstmt, rs);
	}
  }
	
	//빅데이터 / 인공지능 관련사업
	//	데이터를 판매
	//		DB를 직접 건들게 - 위험함
	//		파일로 만들어 주기 - 용량 문제
	//		요청하면 데이터를 제공해주는 시스템을 만들어주자!!
	//		  제공하는 쪽, 사용하는 쪽 사이의 약속된 형태가 있어야 
	// 		  전 세계적으로 약속된 형태가 있음(XML, JSON)
	
	public static String getAllFruit2(HttpServletRequest req) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		StringBuffer sb = null;  
		
		try {
			  
		  con = MemberDBManager.connect("hyonPool");  
		  String sql = "select * from sep26_fruit order by f_price";
		  
		  pstmt = con.prepareStatement(sql);
		  rs = pstmt.executeQuery();
		  
		  sb = new StringBuffer();
		  sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		  sb.append("<sep26_fruit>");
		  while(rs.next()) {
			 sb.append("<fruit>");
			 sb.append("<f_name>" + rs.getString("f_name") + "</f_name>");
			 sb.append("<f_price>" + rs.getInt("f_price") + "</f_price>");
			 sb.append("</fruit>");
		  }
		  sb.append("</sep26_fruit>");
		  return sb.toString();
	  }catch(Exception e){
		  e.printStackTrace();
		  return "오류";
	  }finally {
		  MemberDBManager.close(con, pstmt, rs);
	  }
	  }	
	
	
public static String getAllFruit3(HttpServletRequest req) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			  
		  con = MemberDBManager.connect("hyonPool");  
		  String sql = "select * from sep26_fruit order by f_price";
		  
		  pstmt = con.prepareStatement(sql);
		  rs = pstmt.executeQuery();
		  
		  StringBuffer sb = new StringBuffer();
		  boolean isFirst = true;
		  sb.append("[");              
		  while(rs.next()) {   
			if(isFirst) {
				isFirst = false;
			}else {
				sb.append(",");
			}
			sb.append("{");
			sb.append("\"f_name\":\"" + rs.getString("f_name") + "\",");
			sb.append("\"f_price\":" + rs.getInt("f_price"));
			sb.append("}");
		  }
		  sb.append("]");
		  return sb.toString();
	  }catch(Exception e){
		  e.printStackTrace();
		  return "오류";
	  }finally {
		  MemberDBManager.close(con, pstmt, rs);
	  }
	  }		
}
