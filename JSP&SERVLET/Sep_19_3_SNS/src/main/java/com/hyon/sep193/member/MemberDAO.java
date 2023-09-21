package com.hyon.sep193.member;

import java.io.File;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;

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
			con = MemberDBManager.connect("hyonPool");	

			req.setCharacterEncoding("UTF-8");
			String reqId = req.getParameter("m_id");
			String reqPassword = req.getParameter("m_password");		
			
			//해킹 기법 - SQL Injection
			// 보안상 취약점을 이용해서 데이터베이스가 비정상적인 동작을 하게 하는 기법
			// String sql ="select * from sns_member where m_id=? or '1' or '1'"
			String sql ="select * from sns_member where m_id=?";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1,reqId);
			
			rs = pstmt.executeQuery();

			if(rs.next()) {
				String dbPw = rs.getString("m_password");
				if(dbPw.equals(reqPassword)) {
				Member member = new Member(rs.getString("m_id"),dbPw, rs.getString("m_name"),
				rs.getString("m_phonenum"),rs.getDate("m_birthday"),
				URLDecoder.decode(rs.getString("m_photo"),"UTF-8"));
				
				req.setAttribute("r","<script>alert('로그인에 성공했습니다!');</script>");
				
				req.getSession().setAttribute("member", member);
				req.getSession().setMaxInactiveInterval(600);
				
				Cookie c = new Cookie("lastLoginID",reqId);
				c.setMaxAge(60*60*24*5);
				res.addCookie(c);
				
				}else {
				req.setAttribute("r","<script>alert('로그인에 실패했습니다!');location.href='HomeController';</script>");
				}
			  }
			
		}catch(Exception e) {
			
		}finally {
			MemberDBManager.close(con, pstmt, rs);
		}
	}
	
	//로그아웃 메소드
	public void logout(HttpServletRequest req) {
		req.getSession().setAttribute("member", null);
		req.setAttribute("r","<script>alert('로그아웃에 성공했습니다!');</script>");
	}
	
	//회원 가입 메소드
	public void join(HttpServletRequest req) {
		String path =req.getServletContext().getRealPath("img");
		try {
			mr = new MultipartRequest(req, path, 10*1024*1024,"UTF-8",new DefaultFileRenamePolicy());
			//file name 중복 처리!
			
			con = MemberDBManager.connect("hyonPool");
			
			String m_id = mr.getParameter("m_id");
			String m_password = mr.getParameter("m_password");
			String m_name = mr.getParameter("m_name");
			String m_phonenum = mr.getParameter("m_phonenum");
			int y = Integer.parseInt(mr.getParameter("m_birthYear"));
			int m = Integer.parseInt(mr.getParameter("m_birthMonth"));
			int d = Integer.parseInt(mr.getParameter("m_birthDay"));
			String m_birthday = String.format("%s%02d%02d", y,m,d);			
			String m_photo = mr.getFilesystemName("m_photo");
			m_photo = URLEncoder.encode(m_photo, "UTF-8").replace("+", " ");
			
			String sql = "insert into sns_member values(?,?,?,?,to_date(?,'YYYYMMDD'),?)";
			pstmt=con.prepareStatement(sql); 
			
			pstmt.setString(1,m_id);
			pstmt.setString(2,m_password);
			pstmt.setString(3,m_name);
			pstmt.setString(4,m_phonenum);
			pstmt.setString(5,m_birthday);
			pstmt.setString(6,m_photo);
			
			if(pstmt.executeUpdate()==1) {
				req.setAttribute("r", "회원 가입 성공!");
			}
		}catch(Exception e){ 
			e.printStackTrace();
			//DB서버 문제로 가입은 실패지만 업로드는 되어 있는 상태
			//사진 파일 지워줘야
			File f = new File(path + "/" + mr.getFilesystemName("m_photo"));
			f.delete();
			req.setAttribute("r", "회원 가입 실패");
		}finally {
			MemberDBManager.close(con, pstmt, null);
		}
	}
	
	//회원 정보 수정
		public void update(HttpServletRequest req) {
			String path =req.getServletContext().getRealPath("img");
			try {
				mr = new MultipartRequest(req, path, 10*1024*1024,"UTF-8",new DefaultFileRenamePolicy());
				//file name 중복 처리!
				
				con = MemberDBManager.connect("hyonPool");
				
				String m_id = mr.getParameter("m_id");
				String m_password = mr.getParameter("m_password");
				String m_name = mr.getParameter("m_name");
				String m_phonenum = mr.getParameter("m_phonenum");
				int y = Integer.parseInt(mr.getParameter("m_birthYear"));
				int m = Integer.parseInt(mr.getParameter("m_birthMonth"));
				int d = Integer.parseInt(mr.getParameter("m_birthDay"));
				String m_birthday = String.format("%s%02d%02d", y,m,d);
				String m_photo = mr.getFilesystemName("m_photo");
				
				if(m_photo != null) {
					m_photo = URLEncoder.encode(m_photo, "UTF-8").replace("+", " ");
					String sql = "update sns_member set m_password=?, m_name=?, m_phonenum=?,"
							+ "m_birthday=to_date(?,'YYYYMMDD'),m_photo=? where m_id=?";
					pstmt=con.prepareStatement(sql); 
					
					pstmt.setString(1,m_password);
					pstmt.setString(2,m_name);
					pstmt.setString(3,m_phonenum);
					pstmt.setString(4,m_birthday);
					pstmt.setString(5,m_photo);
					pstmt.setString(6,m_id);
					
					if(pstmt.executeUpdate()==1) {
						req.setAttribute("r", "<script>alert('수정 성공');</script>");
					}
					else {
						req.setAttribute("r", "<script>alert('수정 실패');</script>");
					}
				}
				else {
					String sql = "update sns_member set m_password=?, m_name=?, m_phonenum=?,"
							+ "m_birthday=to_date(?,'YYYYMMDD') where m_id=?";
					pstmt=con.prepareStatement(sql); 
					
					pstmt.setString(1,m_password);
					pstmt.setString(2,m_name);
					pstmt.setString(3,m_phonenum);
					pstmt.setString(4,m_birthday);
					pstmt.setString(5,m_id);
					
					if(pstmt.executeUpdate()==1) {
						req.setAttribute("r", "<script>alert('수정 성공');</script>");
					}
					else {
						req.setAttribute("r", "<script>alert('수정 실패 1');</script>");
					}
				}
	     	}catch(Exception e){ 
				e.printStackTrace();
				//업로드는 되어 있는 상태
				//사진 파일 지워줘야
				File f = new File(path + "/" + mr.getFilesystemName("m_photo"));
				f.delete();
				req.setAttribute("r", "<script>alert('수정 실패');</script>");
			}finally {
				MemberDBManager.close(con, pstmt, null);
			}
		}

	
}
