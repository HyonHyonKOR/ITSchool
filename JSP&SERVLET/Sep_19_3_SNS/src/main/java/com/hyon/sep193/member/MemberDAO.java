package com.hyon.sep193.member;

import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hyon.sep193.db.MemberDBManager;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class MemberDAO {

	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	MultipartRequest mr = null;
	
	private static final MemberDAO mdao= new MemberDAO();

	private MemberDAO() {}
	
	
	public static MemberDAO getMdao() {
		return mdao;
	}
	
	//로그인 체크
	public boolean loginCheck(HttpServletRequest req) {
		Member member = (Member)req.getSession().getAttribute("member");
		return (member!=null);
	}
	
	//로그인하는 메소드
	public void login(HttpServletRequest req, HttpServletResponse res) {
		try {
			req.setCharacterEncoding("UTF-8");
			con = MemberDBManager.connect("hyonPool");	

			String sql ="select m_id,m_password from sep19_member";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			String m_id = req.getParameter("m_id");
			String m_password = req.getParameter("m_password");
			
			
			if(m_id.equals("hyon")&& m_password.equals("natsu")) {
				Member member = new Member(m_id,m_password);
				req.getSession().setAttribute("member", member);
				req.getSession().setMaxInactiveInterval(600);
			}
			
			Cookie c = new Cookie("lastLoginID",m_id);
			c.setMaxAge(600);
			res.addCookie(c);
			
		}catch(Exception e) {
			
		}finally {
			MemberDBManager.close(con, pstmt, rs);
		}
	}
	
	//회원 가입 메소드
	public void Join(HttpServletRequest req) {
		try {
			req.setCharacterEncoding("UTF-8");
			String path =req.getServletContext().getRealPath("img");
			
			mr = new MultipartRequest(req, path, 10*1024*1024,"UTF-8",new DefaultFileRenamePolicy());
			
			con = MemberDBManager.connect("hyonPool");
			String sql = "insert into sep19_member values(?,?,?,?,?,?,?,?)";
			
			pstmt=con.prepareStatement(sql); 
			
			String m_photo = mr.getFilesystemName("m_photo");
			m_photo = URLEncoder.encode(m_photo, "UTF-8").replace("+", "");
			
			String m_id = mr.getParameter("m_id");
			String m_password = mr.getParameter("m_password");
			String m_name = mr.getParameter("m_name");
			int m_phonenum = Integer.parseInt(mr.getParameter("m_phonenum"));
			int m_birthYear = Integer.parseInt(mr.getParameter("m_birthYear"));
			int m_birthMonth = Integer.parseInt(mr.getParameter("m_birthMonth"));
			int m_birthDay = Integer.parseInt(mr.getParameter("m_birthDay"));
			
			Member member = new Member(m_id,m_password,m_name,m_phonenum,m_birthYear,m_birthMonth,m_birthDay,m_photo);
			
			pstmt.setString(1,m_id);
			pstmt.setString(2,m_password);
			pstmt.setString(3,m_name);
			pstmt.setInt(4,m_phonenum);
			pstmt.setInt(5,m_birthYear);
			pstmt.setInt(6,m_birthMonth);
			pstmt.setInt(7,m_birthDay);
			pstmt.setString(8,m_photo);
			
			if(pstmt.executeUpdate()==1) {
				
			}
		}catch(Exception e){
			
		}finally {
			MemberDBManager.close(con, pstmt, null);
		}
	}

	
}
