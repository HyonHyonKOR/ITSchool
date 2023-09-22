package com.hyon.sep221.member;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hyon.sep221.db.MemberDBManager;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class MemberDAO {
	
	
	//회원 등록
	public static void signUp(HttpServletRequest req) {
		
		String path = null;	
		MultipartRequest mr = null;
		
		try {
			path = req.getServletContext().getRealPath("img");
			System.out.println(path);
			mr = new MultipartRequest(req, path,10*1024*1024,"UTF-8",
					new DefaultFileRenamePolicy());
		}catch(Exception e) { 
			e.printStackTrace();
			req.setAttribute("r", "<script>회원가입 실패(사진파일 용량)</script>");
			return;
		}
		
		//파일 업로드 성공시에 계속 진행
		Connection con = null;
		PreparedStatement pstmt = null;
			try {
				con = MemberDBManager.connect("hyonPool");
				
				String m_id = mr.getParameter("m_id");
				String m_pw = mr.getParameter("m_pw");
				String m_name = mr.getParameter("m_name");
				String m_phone = mr.getParameter("m_phone");
				String y = mr.getParameter("m_birthYear");
				int m = Integer.parseInt(mr.getParameter("m_birthMonth"));
				int d = Integer.parseInt(mr.getParameter("m_birthDay"));
				String m_birthday = String.format("%s%02d%02d", y,m,d);			
				String m_photo = mr.getFilesystemName("m_photo");
			
				m_photo = URLEncoder.encode(m_photo, "UTF-8").replace("+", " ");
				
				String sql = "insert into sns_member values(?,?,?,?,to_date(?,'YYYYMMDD'),?)";
				pstmt= con.prepareStatement(sql); 
				
				pstmt.setString(1,m_id);
				pstmt.setString(2,m_pw);
				pstmt.setString(3,m_name);
				pstmt.setString(4,m_phone);
				pstmt.setString(5,m_birthday);
				pstmt.setString(6,m_photo);
				
				if(pstmt.executeUpdate()==1) 
					req.setAttribute("r", "<script>alert('가입을 환영합니다!');</script>");
				
			}catch(Exception e){ 
				e.printStackTrace();
				//DB서버 문제로 가입은 실패한 상태지만 업로드는 되어 있는 상태
				//사진 파일을 지워줘야한다.
				File f = new File(path + "/" + mr.getFilesystemName("m_photo"));
				f.delete();
				req.setAttribute("r", "<script>alert('잠시 후에 다시 시도해주세요.');</script>");
			}finally {
				MemberDBManager.close(con, pstmt, null);
			}
		}//SignUp()
	
	
		public static void login(HttpServletRequest req, HttpServletResponse res) {
	
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			try {
				con = MemberDBManager.connect("hyonPool");
				
				req.setCharacterEncoding("UTF-8");
				String reqId = req.getParameter("m_id");
				String reqPw = req.getParameter("m_pw");
			
				// String sql = "select * from sns_member where m_id='1' or '1'='1';drop table sns_member...";
				// 해킹 기법 - SQL Injection
				// 	보안상 취약점을 이용해서 데이터베이스가 비정상적인 동작을 하게 하는 기법
				String sql = "select * from sns_member where m_id=?";
				
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, reqId);
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					if(reqPw.equals(rs.getString("m_pw"))) {
						Member m = new Member(
						rs.getString("m_id"),		
						rs.getString("m_pw"),
						rs.getString("m_name"),
						rs.getString("m_phone"), 
						rs.getDate("m_birthday"),
						URLDecoder.decode(rs.getString("m_photo"), "UTF-8"));		
					
					req.getSession().setAttribute("loginMember", m);
					req.getSession().setMaxInactiveInterval(600);	
						
					Cookie c = new Cookie("lastLoginId", reqId);
					c.setMaxAge(60*60*24*5);
					res.addCookie(c);
					req.setAttribute("r", "<script>alert('로그인 되었습니다.');</script>");
					}else {
						req.setAttribute("r", "<script>alert('잘못된 비밀번호입니다.');</script>");
					}
				}else {
					req.setAttribute("r", "<script>alert('존재하지 않는 ID입니다.');</script>");
				}
				
		    }catch(Exception e) {
		    	e.printStackTrace();
		    	req.setAttribute("r", "<script>alert('잠시 후에 다시 시도해주세요.');</script>");
		    }finally {
		    	MemberDBManager.close(con, pstmt, null);
		    }
		}//login()	
		
		public static boolean loginCheck(HttpServletRequest req) {
			Member m = (Member)req.getSession().getAttribute("loginMember");
			if(m!=null) {
				req.setAttribute("lp", "member/welcome.jsp");
				return true;
			}
			req.setAttribute("lp", "member/login.jsp");
			return false;
		}//loginCheck
			
		
		public static void logout(HttpServletRequest req) {
			req.getSession().setAttribute("loginMember", null);
		}//logout
		
		public static void update(HttpServletRequest req) {
			
			String path = null;	
			MultipartRequest mr = null;
			Member m = (Member)req.getSession().getAttribute("loginMember");
			String old_m_photo = m.getM_photo();
			String new_m_photo = null;
			
			try {
				path=req.getServletContext().getRealPath("img");
				System.out.println(path);
				mr= new MultipartRequest(req, path,1024*1024*10,"UTF-8",
				new DefaultFileRenamePolicy());
				
				new_m_photo = mr.getFilesystemName("m_photo");
				if(new_m_photo != null) {
					new_m_photo = URLEncoder.encode(new_m_photo, "UTF-8");
				}else {
					new_m_photo = old_m_photo;
				}
			}catch(Exception e) {
				e.printStackTrace(); // NullPointer는 여기서 뜨는게 아님!!!!
				System.out.println("파일용량...");
				return;
			}
			
			Connection con = null;
			PreparedStatement pstmt = null;
			try {
				con = MemberDBManager.connect("hyonPool");
				String m_id = mr.getParameter("m_id");
				String m_pw = mr.getParameter("m_pw");
				String m_name = mr.getParameter("m_name");
				String m_phone = mr.getParameter("m_phone");
				String y = mr.getParameter("m_birthYear");
				int m_m = Integer.parseInt(mr.getParameter("m_birthMonth"));
				int d = Integer.parseInt(mr.getParameter("m_birthDay"));
				String m_birthday = String.format("%s%02d%02d", y,m_m,d);			
			
				String sql = "update sns_member set m_pw=?, m_name=?, m_phone=?, "
						+ "m_birthday=to_date(?, 'YYYYMMDD'), m_photo=? where m_id=?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, m_pw);
				pstmt.setString(2, m_name);
				pstmt.setString(3, m_phone);
				pstmt.setString(4, m_birthday);
				pstmt.setString(5, new_m_photo);
				pstmt.setString(6, m_id);
				
				if (pstmt.executeUpdate() == 1) {
					req.setAttribute("r", "<script>alert('정보가 수정 되었습니다.');</script>");
					if (!new_m_photo.equals(old_m_photo)) { 
					// 프사를 바꿨으면 기존 사진파일 지우기
					new File(path + "/" + URLDecoder.decode(old_m_photo, "UTF-8")).delete();
					}
					SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
					m = new Member(m_id, m_pw, m_name, m_phone, sdf.parse(m_birthday), 
					URLDecoder.decode(new_m_photo, "UTF-8"));
					req.getSession().setAttribute("loginMember", m);
				}else {
					req.setAttribute("r", "<script>alert('정보 수정에 실패했습니다.');</script>");
					if (!new_m_photo.equals(old_m_photo)) { 
					new File(path + "/" + URLDecoder.decode(new_m_photo, "UTF-8")).delete();
					}
				}
			}catch(Exception e) {
				e.printStackTrace();
				req.setAttribute("r", "<script>alert('다시 시도해주세요.');</script>");
				if(!new_m_photo.equals(old_m_photo)){
					try {
						new File(path + "/" + URLEncoder.encode(new_m_photo,"UTF-8")).delete();
					}catch (UnsupportedEncodingException e1) {
						e1.printStackTrace();
					}
					
				}
				
			}
			finally {
				MemberDBManager.close(con, pstmt, null);
			}
		}//Update()
		
		public static void delete(HttpServletRequest req) {
			
		}
		
		
		
	  }//DAOclass
	

