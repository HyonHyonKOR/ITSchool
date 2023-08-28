package com.hyon.aug28.main;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.hyon.aug28.reservation.Reservation;
import com.hyon.aug28.torikizoku.Torikizoku;
import com.hyon.db.manager.HyonDBManager;

public class DAO {

	//1
	public static String insertReservation(Reservation r) {		
		Connection con = null;
		PreparedStatement ptsmt = null;
	
		try {
			con = HyonDBManager.getConnection();
			
			String sql="INSERT INTO RESERVATION VALUES"
					+ "(RESERVATION_SEQ.NEXTVAL,?,?,?,?)";
			
			ptsmt = con.prepareStatement(sql);
			ptsmt.setString(1, r.getName());
			ptsmt.setDate(2, new Date(r.getWhen().getTime()));
			ptsmt.setString(3, r.getPhoneNum());
			ptsmt.setString(4, r.getLocation());
					
			if(ptsmt.executeUpdate()==1) {
				return "予約成功";
			}
			return "";  // java文法上、必修
		}catch(Exception e) {
			e.printStackTrace();
			return "予約失敗";
		}finally {
			HyonDBManager.close(con, ptsmt, null);
		}
		
	}
	
	//2
	public static String insertTorikizoku(Torikizoku t) {		
		Connection con = null;
		PreparedStatement ptsmt = null;
	
		try {
			con = HyonDBManager.getConnection();
			
			String sql="INSERT INTO TORIKIZOKU VALUES"
					+ "(?,?,?)";
			
			ptsmt = con.prepareStatement(sql);
			ptsmt.setString(1, t.getLocation());
			ptsmt.setString(2, t.getName());
			ptsmt.setInt(3, t.getSeat());
					
			if(ptsmt.executeUpdate()==1) {
				return "店舗登録成功";
			}
			return "";  // java文法上、必修
		}catch(Exception e) {
			return "予約失敗";
		}finally {
			HyonDBManager.close(con, ptsmt, null);
		}
		
	}
	
	//3
	public static ArrayList<Reservation> selectAllReserve(){
	  Connection con = null;
      PreparedStatement ptsmt = null;
      ResultSet rs = null;
      
      try {
    	  con = HyonDBManager.getConnection();
    	  String sql = "SELECT * FROM RESERVATION";
    	  ptsmt = con.prepareStatement(sql);
    	  rs = ptsmt.executeQuery();
    	  
    	  ArrayList<Reservation> rlist = new ArrayList<>();
    	  while(rs.next()) {
    		  Reservation r = new Reservation();
    		  r.setNo(rs.getInt("r_no"));
			  r.setName(rs.getString("r_name"));
			  r.setWhen(rs.getDate("r_time"));
			  r.setPhoneNum(rs.getString("r_phonenum"));
			  r.setLocation(rs.getString("r_location"));
			  rlist.add(r);
    	  }
    	 return rlist; 
      }catch(Exception e) {
    	  return null;
      }finally {
    	  HyonDBManager.close(con, ptsmt, rs);
      }
	
	
	}
	
	//4
	public static ArrayList<Torikizoku> selectAllToriki(){
		Connection con = null;
		PreparedStatement ptsmt = null;
		ResultSet rs = null;
			
		try {
			con = HyonDBManager.getConnection();
			String sql = "SELECT * FROM TORIKIZOKU";
			ptsmt = con.prepareStatement(sql);
			rs = ptsmt.executeQuery();
			
			ArrayList<Torikizoku>tlist = new ArrayList<>();
			while(rs.next()) {
				Torikizoku t = new Torikizoku();
				t.setLocation(rs.getString("t_location")); 
				t.setName(rs.getString("t_name")); 
				t.setSeat(rs.getInt("t_seat")); 
				tlist.add(t);
			}
			return tlist;
		} catch (Exception e) {
			return null;
		}finally {
			HyonDBManager.close(con, ptsmt, rs);
		}
	}
	
}
