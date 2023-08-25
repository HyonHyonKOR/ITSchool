package com.hyon.aug251.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertMain2 {
     public static void main(String[] args) {
    	 Connection con = null;
		 //연결
    	 try{
         String addr = "jdbc:oracle:thin:@localhost:1521:xe";    	 
    	 con = DriverManager.getConnection(addr,"rnjsgurah2","1234");
    	 
    	 //연결이 되면 마켓 정보들 입력 받기
    	 Scanner sc = new Scanner(System.in);
    	 System.out.print("마트 이름 : ");
    	 String name = sc.next();
    	 System.out.print("지점명 : ");
    	 String location = sc.next();
    	 System.out.print("몇 평 : ");
    	 int space = sc.nextInt();
    	 System.out.print("주자 가능 대수 : ");
    	 int park = sc.nextInt();
    	 sc.close();
    	 
    	 //SQL => market테이블에 넣을 것 
    	 PreparedStatement pstmt = null;
    	 String sql ="insert into market "
    	 		+ "values(market_seq.nextval,"
    	 		+ "?,?,?,?)";
    	 
    	 pstmt =con.prepareStatement(sql);
    	 //?에 값 채우기 : pstmt.setXXX(물음표번호, 값)
    	 // XXX :자료형, 물음표번호는 1부터 시작 
    	 pstmt.setString(1, name);
    	 pstmt.setString(2, location);
    	 pstmt.setInt(3, space);
    	 pstmt.setInt(4, park);
    	 
    	 //성공 메시지
    	 int datacount = pstmt.executeUpdate();
    	 if(datacount==1) {
    		 System.out.println("Success");
    	 }
    	 
    	 pstmt.close();
    	 
    	 }catch(Exception e) {
    		 e.printStackTrace();
    	 }
    	 try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
