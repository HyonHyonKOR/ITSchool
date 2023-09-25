package com.hyon.sep221.board;

import java.net.URLDecoder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.hyon.sep221.db.MemberDBManager;
import com.hyon.sep221.member.Member;

public class BoardDAO {
	
	private int allBoardMsgCount;
	
	private static final BoardDAO BDAO = new BoardDAO();
	
	private BoardDAO() {
		// TODO Auto-generated constructor stub
	}

	public static BoardDAO getBdao() {
		return BDAO;
	}
	
	public void countAllBoardMsg() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = MemberDBManager.connect("hyonPool");
			String sql = "select count(*) from sns_board";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			rs.next();
			allBoardMsgCount = rs.getInt("count(*)");
			System.out.println(allBoardMsgCount);
		} catch (Exception e) {
			e.printStackTrace();
		}
		MemberDBManager.close(con, pstmt, rs);
		
	}
	
	public void write(HttpServletRequest req) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con= MemberDBManager.connect("hyonPool");	
			
			Member m = (Member)req.getSession().getAttribute("loginMember");
			String b_writer = m.getM_id();
			String b_text = req.getParameter("b_text").replace("\r\n","<br>");
			
			//처음 글 작성 시 세션에 formerToken은 존재하지 않으므로 null -> 루트 1)로 
			//글 작성 성공하면 루트1에서 formerToken이라는 세션 소속 어트리뷰트 생성
			//그 후 Tokenmanager의 make 메소드로 인하여 해당 페이지의 어트리뷰트인 generatedToken가 생성됨
			//<input name="token" type="hidden" value="${generatedToken }"> 로 인하여 token=generateToken
			//첫 번째 요청 때 찍힌 시간값의 토큰이 남는다(두번 째 아님)
			//그러므로 get요청 이후 다시 새로고침을 하면 token이 남아있는 상태가 되어 루드 2)로 빠짐
			//쉽게 말하면 토큰을 두 번 콰쾅 찍어서 도장을 찍은 시간으로 중복 체크 
			
			String formerToken = (String)req.getSession().getAttribute("formerToken");
			System.out.println(formerToken);
			
			String token = req.getParameter("token");
			System.out.println(token);
			
			//루트 1)
			if(formerToken == null || !token.equals(formerToken)) {
				String sql = "insert into sns_board values(sns_board_seq.nextval, ?, sysdate, ?)";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1,b_writer);
				pstmt.setString(2,b_text);
				if(pstmt.executeUpdate()==1) {
					req.setAttribute("r", "<script>alert('글쓰기 성공');</script>");
					req.getSession().setAttribute("formerToken", token);
					
				//루트 2)	
			    }else {
			    	req.setAttribute("r", "<script>alert('새로고침');</script>");
			    }
			
		   }
		}catch(Exception e) {
			e.printStackTrace();
			req.setAttribute("r", "<script>alert('글쓰기 실패');</script>");

		}
		MemberDBManager.close(con, pstmt, null);
	}
	
	//페이지
	public void getBoardMsg(int pageNo, HttpServletRequest req) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = MemberDBManager.connect("hyonPool");
			
			int boardCount = allBoardMsgCount;
			int boardPerPage = 3;
			int pageCount = (int)Math.ceil(boardCount/(double)boardPerPage);
			
			req.setAttribute("pageCount", pageCount);
			req.setAttribute("pageNo", pageNo);
			
			int start = boardPerPage*(pageNo-1) + 1;
			int end = (pageNo == pageCount)?boardCount:(start + boardPerPage - 1);
			
			String sql = "select * "
					+ "from ( "
					+ "	select rownum as rn, b_no, b_writer, b_when, b_text, m_photo "
					+ " from ( "
					+ "		select * "
					+ "		from sns_board, sns_member "
					+ "		where b_writer = m_id "
					+ "		order by b_when desc "
					+ "		) "
					+ "	)"
					+ "where rn >= ? and rn < = ?";
	
			pstmt = con.prepareStatement(sql);	
			
			pstmt.setInt(1,start);
			pstmt.setInt(2,end);
			
			rs = pstmt.executeQuery();
			
			ArrayList<Board> boards = new ArrayList<Board>();
			Board board = null;
			while (rs.next()) {
				board = new Board();
				board.setB_no(rs.getInt("b_no"));
				board.setB_writer(rs.getString("b_writer"));
				board.setB_when(rs.getDate("b_when"));
				board.setB_text(rs.getString("b_text"));
				board.setM_photo(URLDecoder.decode(rs.getString("m_photo"), "UTF-8"));
				boards.add(board);
			}
			req.setAttribute("boards", boards);
		} catch (Exception e) {
			e.printStackTrace();
		}
		MemberDBManager.close(con, pstmt, rs);
	}
	
	//수정
	public void update(HttpServletRequest req) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = MemberDBManager.connect("hyonPool");
			req.setCharacterEncoding("UTF-8");

			int b_no = Integer.parseInt(req.getParameter("b_no"));
			String b_text = URLDecoder.decode(req.getParameter("b_text"),"UTF-8");
		
			String sql = "update sns_board set b_text=?,b_when=sysdate where b_no=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, b_text);
			pstmt.setInt(2,b_no);
	
			if(pstmt.executeUpdate()==1) {
				req.setAttribute("r", "<script>alert('수정 성공');</script>");
			}else {
				req.setAttribute("r", "<script>alert('수정 실패');</script>)");
			}
		}catch(Exception e) {
			e.printStackTrace();
			req.setAttribute("r", "<script>alert('DB 수정 실패');</script>)");
		}finally {
			MemberDBManager.close(con, pstmt, null);
		}
	}
	
	//삭제
	public void delete(HttpServletRequest req) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = MemberDBManager.connect("hyonPool");
			req.setCharacterEncoding("UTF-8");
			
			int b_no = Integer.parseInt(req.getParameter("b_no"));
			
			String sql = "delete from sns_board where b_no=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,b_no);
			
			if(pstmt.executeUpdate()==1) {
				req.setAttribute("r", "<script>alert('삭제 성공');</script>");
			}else {
				req.setAttribute("r", "<script>alert('삭제 실패');</script>)");
			}
		}catch(Exception e) {
			e.printStackTrace();
			req.setAttribute("r", "<script>alert('DB 진입 실패');</script>)");
		}finally {
			MemberDBManager.close(con, pstmt, null);
		}
	}
}
